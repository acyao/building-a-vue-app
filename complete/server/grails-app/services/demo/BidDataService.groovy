package demo

import grails.gorm.services.Service

@Service(Bid)
interface BidDataService {
    Bid save(String date,String amount)
}