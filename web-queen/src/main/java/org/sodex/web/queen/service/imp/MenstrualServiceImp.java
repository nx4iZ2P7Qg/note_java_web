package org.sodex.web.queen.service.imp;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sodex.web.common.bean.Menstrual;
import org.sodex.web.common.bean.PageVo;
import org.sodex.web.common.repository.MenstrualRepository;
import org.sodex.web.common.util.Json;
import org.sodex.web.queen.service.MenstrualService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MenstrualServiceImp implements MenstrualService {

    private static final Logger logger = LoggerFactory.getLogger(MenstrualServiceImp.class);

    @Resource
    MenstrualRepository menstrualRepository;

    @Override
    public String glance() throws Exception {
        Sort sort = new Sort(Sort.Direction.ASC, "id");
        List<Menstrual> menstrualList = menstrualRepository.findAll(sort);
        logger.info("glance-menstrualList = {}", Json.MAPPER.write(menstrualList));
        // 取13个日期
        List<Menstrual> latestList = menstrualList.subList(menstrualList.size() - 13, menstrualList.size());
        // 计算出12个间隔
        double[] doubles = new double[latestList.size() - 1];
        for (int i = 0; i < latestList.size() - 1; i++) {
            Menstrual former = latestList.get(i);
            Menstrual latter = latestList.get(i + 1);
            long days = ChronoUnit.DAYS.between(former.getDt(), latter.getDt());
            doubles[i] = days;
        }
        logger.debug("glance-doubles = {}", Arrays.toString(doubles));
        
        Map<String, Object> reMap = new HashMap<>();
        LocalDate lastDay = latestList.get(latestList.size() - 1).getDt();
        reMap.put("lastDay", lastDay.format(DateTimeFormatter.ISO_LOCAL_DATE));
        DescriptiveStatistics ds = new DescriptiveStatistics(doubles);
        // 平均数
        double mean = Math.round(ds.getMean());
        reMap.put("mean", mean);
        // 样本方差
//        reMap.put("variance", ds.getVariance());
        // 样本均方差
//        reMap.put("standardDeviation", ds.getStandardDeviation());
        // 总体方差
//        reMap.put("populationVariance", ds.getPopulationVariance());
        // 总体均方差
        String varDays = new DecimalFormat("0.0").format(Math.sqrt(ds.getPopulationVariance()));
        reMap.put("varDays", varDays);
        double days = doubles[doubles.length - 1];
        reMap.put("days", days);
        String next = lastDay.plusDays(Math.round(mean)) + " +- " + varDays;
        reMap.put("next", next);
        logger.debug("glance-reMap = {}", reMap);
        return Json.MAPPER.write(reMap);
    }

    @Override
    public String getMenstruals(PageVo pageVo) throws Exception {
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Page<Menstrual> menstrualList = menstrualRepository
                .findAll(PageRequest.of(pageVo.getNumber(), pageVo.getSize(), sort));
        logger.debug("tableDetail-menstrualList = {}", Json.MAPPER.write(menstrualList));
        return Json.MAPPER.write(menstrualList);
    }

    private void test() throws Exception {
    }
}
