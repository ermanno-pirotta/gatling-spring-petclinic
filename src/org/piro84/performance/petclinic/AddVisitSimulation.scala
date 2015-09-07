package org.piro84.performance.petclinic

import org.piro84.performance.petclinic.config.Config
import scala.concurrent.duration._
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._
import org.piro84.performance.petclinic.request.OwnerRequest
import org.piro84.performance.petclinic.request.VisitRequest

class AddVisitSimulation extends Simulation {

  val scn = scenario("AddVisitSimulation")
    .exec(OwnerRequest.ShowLanding)

    .pause(Config.THINK_TIME_DEFAULT_SECONDS)

    .repeat(Config.REPEAT_COUNT) {
      exec(OwnerRequest.ListAllByLastName)

        .pause(Config.THINK_TIME_DEFAULT_SECONDS)

        .exec(OwnerRequest.GetRandomOwner)

        .pause(Config.THINK_TIME_DEFAULT_SECONDS)

        .exec(VisitRequest.NavigateToNewVisitForm)

        .pause(Config.THINK_TIME_DEFAULT_SECONDS)

        .exec(VisitRequest.AddNewVisit)
    }

  setUp(scn.inject(constantUsersPerSec(Config.USER_PER_SEC) during (Config.DURATION seconds)))
    .protocols(Config.HTTP_PROTOCOL)
}