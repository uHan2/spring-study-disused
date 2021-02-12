package com.example.adminstudy.repository;

import com.example.adminstudy.AdminStudyApplicationTests;
import com.example.adminstudy.model.entity.Partner;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

class PartnerRepositoryTest extends AdminStudyApplicationTests
{
    @Autowired
    private PartnerRepository partnerRepository;

    @Test
    @Order(1)
    void create()
    {
        String name = "Partner01";
        String status = "REGISTERED";
        String address = "서울시 강남구";
        String callCenter = "1234-test-test";
        String partnerNumber = "010-test-test";
        String businessNumber = "0101-test-test";
        String ceoName = "홍길동";
        LocalDateTime registeredAt = LocalDateTime.now();
        LocalDateTime createdAt = LocalDateTime.now();
        String createdBy = "AdminServer";

        Partner partner = new Partner();
        partner.setName(name);
        partner.setStatus(status);
        partner.setAddress(address);
        partner.setCallCenter(callCenter);
        partner.setPartnerNumber(partnerNumber);
        partner.setBusinessNumber(businessNumber);
        partner.setCeoName(ceoName);
        partner.setRegisteredAt(registeredAt);
        partner.setCreatedAt(createdAt);
        partner.setCreatedBy(createdBy);

        Partner newPartner = partnerRepository.save(partner);

        assertThat(newPartner).isNotNull();
        assertThat(newPartner.getName()).isEqualTo(name);
    }

    @Test
    @Order(2)
    void read()
    {
        Optional<Partner> newPartner = partnerRepository.findById(1L);
        assertThat(newPartner).isNotNull();
    }
}