package com.grupocontable.website.service.Impl;

import com.grupocontable.website.model.BannerHome;
import com.grupocontable.website.repository.BannerHomeRepository;
import com.grupocontable.website.service.BannerHomeService;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.Set;

@Service
public class BannerHomeServiceImp implements BannerHomeService {

    private final BannerHomeRepository bannerHomeRepository;

    public BannerHomeServiceImp(BannerHomeRepository bannerHomeRepository){
        this.bannerHomeRepository = bannerHomeRepository;
    }

    @Override
    public BannerHome agregarBannerHome(BannerHome bannerhome) {
        return bannerHomeRepository.save(bannerhome);
    }

    @Override
    public BannerHome actualizarBannerHome(BannerHome bannerhome) {
        return bannerHomeRepository.save(bannerhome);
    }

    @Override
    public Set<BannerHome> obtenerBannerHomeList() {
        return new LinkedHashSet<>(bannerHomeRepository.findAll());
    }

    @Override
    public BannerHome obtenerBannerHome(Integer bannerhome) {
        return bannerHomeRepository.findById(bannerhome).get();
    }

    @Override
    public void eliminarBannerHome(Integer bannerhome) {
        BannerHome bannerHome = new BannerHome();
        bannerHome.setIdBanner(bannerhome);
        bannerHomeRepository.delete(bannerHome);

    }
}
