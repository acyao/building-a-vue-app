package demo

import groovy.transform.CompileStatic

@CompileStatic
class BootStrap {

    DriverDataService driverDataService
    BidDataService bidDataService
    LicenceDataService licenceDataService
    def init = { servletContext ->
        log.info "Loading database..."
        
		Bid bid1 = bidDataService.save("01/01/2020","5000")
        Bid bid2 = bidDataService.save("02/02/2020","8000")
		Bid bid3 = bidDataService.save("01/01/2020","5555")

        Licence licence1 = licenceDataService.save("ClassA","12345678")
        Licence licence2 = licenceDataService.save("ClassA","24682468")
        Licence licence3 = licenceDataService.save("ClassB","55555555")

		Driver driver1 = driverDataService.save("Susan", licence1, bid1)
        Driver driver2 = driverDataService.save("Joe", licence2, bid2)
		Driver driver3 = driverDataService.save("Peter", licence3, bid3)

    }
    def destroy = {
    }
}
