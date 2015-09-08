package org.piro84.performance.petclinic.request

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.http.check.HttpCheck

/**
 * Contains requests related to the owners' page.
 */
object OwnerRequest {
  
  def selectRandomOwner(): HttpCheck = {
    css("table[id='owners'] a", "href").findAll.transform(RequestUtils.random).saveAs("ownerLink")
  }
  
   def randomVisitForm(): HttpCheck = {
    css("a[href$='/visits/new']", "href").findAll.transform(RequestUtils.random).saveAs("visitLink")
  }
   
  val ShowLanding= {
    exec(http("Navigate to owners page")
      .get("/petclinic/owners/find.html"))
  }
    
  val ListAllByLastName={
    exec(http("List owners by last name")
      .get("/petclinic/owners.html?lastName=")
      .check(selectRandomOwner)  
    )
  }
  
  val GetRandomOwner = {
		  exec(http("Get a random owner")
				  .get("${ownerLink}")
          .check(randomVisitForm))
          
  }
}