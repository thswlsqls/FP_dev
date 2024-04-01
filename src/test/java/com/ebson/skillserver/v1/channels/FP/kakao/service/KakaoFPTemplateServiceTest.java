package com.ebson.skillserver.v1.channels.FP.kakao.service;

import com.ebson.skillserver.common.ChatbotConstants;
import com.ebson.skillserver.common.SkillResponse;
import com.ebson.skillserver.util.UUIDFormatter;
import com.ebson.skillserver.v1.channels.FP.entity.BuilderV1BlockEntity;
import com.ebson.skillserver.v1.channels.FP.repository.BuilderV1BlockEntityRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

@SpringBootTest
public class KakaoFPTemplateServiceTest {

    @Autowired
    KakaoFPTemplateService kakaoFPTemplateService;

    @Autowired
    BuilderV1BlockEntityRepository beRepository;

    @Test
    public void simpleTextTest(){
        SkillResponse sr = new SkillResponse();
        sr.setVersion(ChatbotConstants.VERSION);

        UUID templateId = UUID.fromString(UUIDFormatter.formatToUUID("4144051BEDB711EEB5380A48BC1A5EE1"));
        BuilderV1BlockEntity be = beRepository.getReferenceById("6590ab5b193392115b5a7ff8");
        sr = kakaoFPTemplateService.setTemplateAndReturn(sr, templateId, be);

        Assertions.assertNotNull(sr.getTemplate());
        Assertions.assertTrue(sr.getTemplate().getOutputs().get(0).containsKey("simpleText"));
    }

    @Test
    public void simpleImageTest(){
        SkillResponse sr = new SkillResponse();
        sr.setVersion(ChatbotConstants.VERSION);

        UUID templateId = UUID.fromString(UUIDFormatter.formatToUUID("9C95C4E7EDB711EEB5380A48BC1A5EE1"));
        BuilderV1BlockEntity be = beRepository.getReferenceById("6590ab5b193392115b5a7ff8");
        sr = kakaoFPTemplateService.setTemplateAndReturn(sr, templateId, be);

        Assertions.assertNotNull(sr.getTemplate());
        Assertions.assertTrue(sr.getTemplate().getOutputs().get(0).containsKey("simpleImage"));
    }

    @Test
    public void textCardTest(){
        SkillResponse sr = new SkillResponse();
        sr.setVersion(ChatbotConstants.VERSION);

        UUID templateId = UUID.fromString(UUIDFormatter.formatToUUID("CA3DA19DEDB711EEB5380A48BC1A5EE1"));
        BuilderV1BlockEntity be = beRepository.getReferenceById("6590ab5b193392115b5a7ff8");
        sr = kakaoFPTemplateService.setTemplateAndReturn(sr, templateId, be);

        Assertions.assertNotNull(sr.getTemplate());
        Assertions.assertTrue(sr.getTemplate().getOutputs().get(0).containsKey("textCard"));
    }

    @Test
    public void basicCardTest(){
        SkillResponse sr = new SkillResponse();
        sr.setVersion(ChatbotConstants.VERSION);

        UUID templateId = UUID.fromString(UUIDFormatter.formatToUUID("B4B715E3EDC611EEB5380A48BC1A5EE1"));
        BuilderV1BlockEntity be = beRepository.getReferenceById("6590ab5b193392115b5a7ff8");
        sr = kakaoFPTemplateService.setTemplateAndReturn(sr, templateId, be);

        Assertions.assertNotNull(sr.getTemplate());
        Assertions.assertTrue(sr.getTemplate().getOutputs().get(0).containsKey("basicCard"));
    }

    @Test
    public void commerceCardTest(){
        SkillResponse sr = new SkillResponse();
        sr.setVersion(ChatbotConstants.VERSION);

        UUID templateId = UUID.fromString(UUIDFormatter.formatToUUID("64C3A144EE8511EEB5380A48BC1A5EE1"));
        BuilderV1BlockEntity be = beRepository.getReferenceById("6590ab5b193392115b5a7ff8");
        sr = kakaoFPTemplateService.setTemplateAndReturn(sr, templateId, be);

        Assertions.assertNotNull(sr.getTemplate());
        Assertions.assertTrue(sr.getTemplate().getOutputs().get(0).containsKey("commerceCard"));
    }

    @Test
    public void listCardTest(){
        SkillResponse sr = new SkillResponse();
        sr.setVersion(ChatbotConstants.VERSION);

        UUID templateId = UUID.fromString(UUIDFormatter.formatToUUID("048B8952EE9211EEB5380A48BC1A5EE1"));
        BuilderV1BlockEntity be = beRepository.getReferenceById("6590ab5b193392115b5a7ff8");
        sr = kakaoFPTemplateService.setTemplateAndReturn(sr, templateId, be);

        Assertions.assertNotNull(sr.getTemplate());
        Assertions.assertTrue(sr.getTemplate().getOutputs().get(0).containsKey("listCard"));
    }

    @Test
    public void itemCardTest(){
        SkillResponse sr = new SkillResponse();
        sr.setVersion(ChatbotConstants.VERSION);

        UUID templateId = UUID.fromString(UUIDFormatter.formatToUUID("FF854FEBEF0A11EEB5380A48BC1A5EE1"));
        BuilderV1BlockEntity be = beRepository.getReferenceById("6590ab5b193392115b5a7ff8");
        sr = kakaoFPTemplateService.setTemplateAndReturn(sr, templateId, be);

        Assertions.assertNotNull(sr.getTemplate());
        Assertions.assertTrue(sr.getTemplate().getOutputs().get(0).containsKey("itemCard"));
    }

    @Test
    public void carouselTextCardTest() {
        SkillResponse sr = new SkillResponse();
        sr.setVersion(ChatbotConstants.VERSION);

        UUID templateId = UUID.fromString(UUIDFormatter.formatToUUID("6C5D0ABBEF2511EEB5380A48BC1A5EE1"));
        BuilderV1BlockEntity be = beRepository.getReferenceById("6590ab5b193392115b5a7ff8");
        sr = kakaoFPTemplateService.setTemplateAndReturn(sr, templateId, be);

        Assertions.assertNotNull(sr.getTemplate());
        Assertions.assertTrue(sr.getTemplate().getOutputs().get(0).containsKey("carousel"));
    }


}
