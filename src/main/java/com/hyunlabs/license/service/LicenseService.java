package com.hyunlabs.license.service;

import com.hyunlabs.license.model.License;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.Locale;
import java.util.Random;

@Service
public class LicenseService {

    @Autowired
    MessageSource messageSource;


    public License getLicense(String licenseId, String organizationId) {
        License license = new License();
        license.setId(new Random().nextInt(1000));
        license.setLicenseId(licenseId);
        license.setOrganizationId(organizationId);
        license.setDescription("Software product");
        license.setProductName("Ostock");
        license.setLicenseType("full");
        return license;
    }

    public String createLicense(License license, String organizationId, Locale locale) {
        String responseMessage = null;
        if (license != null) {
            license.setOrganizationId(organizationId);
//            responseMessage = String.format("This is the post and the object is: %s", license,toString());
            responseMessage = String.format(messageSource.getMessage("license.create.message", null, locale), license,toString());
        }
        return responseMessage;
    }

    public String updateLicense(License license, String organizationId, Locale locale) {
        String responseMessage = null;
        if (license != null) {
            license.setOrganizationId(organizationId);
//            responseMessage = String.format("This is the put and the object is: %s", license,toString());
            responseMessage = String.format(messageSource.getMessage("license.update.message", null, locale), license,toString());
        }
        return responseMessage;
    }

    public String deleteLicense(String licenseId, String organizationId, Locale locale) {
        String responseMessage = null;
//        responseMessage = String.format("Deleting license with id: %s", organizationId);
        responseMessage = String.format(messageSource.getMessage("license.delete.message", null, locale), licenseId,toString());
        return responseMessage;
    }
}
