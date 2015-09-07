package org.piro84.performance.petclinic

import org.piro84.performance.petclinic.config.Config
import scala.concurrent.duration._
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class AddVisitSimulation extends Simulation {

	val scn = scenario("AddVisitSimulation")
		.exec(http("request_0")
			.get("/petclinic/owners/find.html"))
		.pause(Config.THINK_TIME_DEFAULT_SECONDS)
		.exec(http("request_1")
			.get("/petclinic/owners.html?lastName="))
		.pause(Config.THINK_TIME_DEFAULT_SECONDS)
		.exec(http("request_2")
			.get("/petclinic/owners/10.html"))
		.pause(Config.THINK_TIME_DEFAULT_SECONDS)
		.exec(http("request_3")
			.get("/petclinic/owners/10/pets/13/visits/new"))
		.pause(Config.THINK_TIME_DEFAULT_SECONDS)
		.exec(http("request_4")
			.post("/petclinic/owners/10/pets/13/visits/new")
			.formParam("date", "2015/09/09")
			.formParam("description", "test visit")
			.formParam("petId", "13"))

  setUp(scn.inject(constantUsersPerSec(Config.USER_PER_SEC) during (Config.DURATION seconds)))
    .protocols(Config.HTTP_PROTOCOL)
}