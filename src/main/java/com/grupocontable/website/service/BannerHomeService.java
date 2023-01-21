package com.grupocontable.website.service;

import com.grupocontable.website.model.BannerHome;

import java.util.Set;

public interface BannerHomeService {
    BannerHome agregarBannerHome(BannerHome bannerhome);
    BannerHome actualizarBannerHome(BannerHome bannerhome);
    Set<BannerHome> obtenerBannerHomeList();
    BannerHome obtenerBannerHome(Integer bannerhome);
    void eliminarBannerHome(Integer bannerhome);
}
