package demo

import grails.gorm.services.Service

@Service(Licence)
interface LicenceDataService {
    Licence save(String licence_class,String licence_no)
}