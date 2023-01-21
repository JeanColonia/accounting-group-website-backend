package com.grupocontable.website.repository;

import com.grupocontable.website.model.BannerHome;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BannerHomeRepository extends JpaRepository<BannerHome, Integer> {
}
