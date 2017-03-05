package com.chumbok

import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._
import com.ning.http.util.Base64
import io.gatling.http.response._
import java.nio.charset.StandardCharsets.UTF_8

class RecordedSimulation extends Simulation {

  val httpProtocol = http
    .baseURL("https://localhost:8443")
    .inferHtmlResources(BlackList(""".*\.js""", """.*\.css""", """.*\.gif""", """.*\.jpeg""", """.*\.jpg""", """.*\.ico""", """.*\.woff""", """.*\.(t|o)tf""", """.*\.png"""), WhiteList())

  val headers_0 = Map("Accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")

  val headers_1 = Map(
    "Accept" -> "text/plain, */*",
    "X-Requested-With" -> "XMLHttpRequest")

  val headers_4 = Map(
    "Pragma" -> "no-cache",
    "X-Requested-With" -> "XMLHttpRequest")

  val headers_6 = Map("Accept" -> "image/png,image/*;q=0.8,*/*;q=0.5")

  val headers_11 = Map(
    "Content-Type" -> "application/x-www-form-urlencoded; charset=UTF-8",
    "Pragma" -> "no-cache",
    "X-Requested-With" -> "XMLHttpRequest")

  val headers_75 = Map(
    "Accept" -> "application/json, text/javascript, */*",
    "Content-Type" -> "application/x-www-form-urlencoded; charset=UTF-8",
    "Pragma" -> "no-cache",
    "X-Requested-With" -> "XMLHttpRequest")

  val uri1 = "https://localhost:8443"
  val uri2 = "https://cdn.rawgit.com/lodash/lodash-compat/3.10.1/lodash.min.js"

  val scn = scenario("RecordedSimulation")
    .exec(http("request_0")
      .get("/modules/customer/index.html")
      .headers(headers_0)
      .resources(http("request_1")
        .get(uri1 + "/modules/login/customerlogin.shtml")
        .headers(headers_1)
        .check(status.is(304)),
        http("request_2")
          .get(uri1 + "/resource/shtml/footer.shtml")
          .headers(headers_1)
          .check(status.is(304)))
      .check(status.is(304)))
    .pause(3)
    .exec(http("request_3")
      .post("/modules/customer/j_security_check")
      .headers(headers_0)
      .formParam("j_username", "mmahmood.ict.bd@gmail.com")
      .formParam("j_password", "12345678")
      .resources(http("request_4")
        .post(uri1 + "/modules/customer/systemInfo.action")
        .headers(headers_4),
        http("request_5")
          .get(uri1 + "/modules/shop/courseCatalogs.shtml")
          .headers(headers_1)
          .check(status.is(304)),
        http("request_6")
          .get(uri1 + "/resource/images/catalog/myCatalogImage")
          .headers(headers_6)
          .check(status.is(404)),
        http("request_7")
          .post(uri1 + "/modules/customer/courseCatalogs.action")
          .headers(headers_4),
        http("request_8")
          .get(uri1 + "/modules/shop/keywords.shtml")
          .headers(headers_1)
          .check(status.is(304)),
        http("request_9")
          .get(uri1 + "/modules/shop/recentViewOfferings.shtml")
          .headers(headers_1)
          .check(status.is(304)),
        http("request_10")
          .post(uri1 + "/modules/customer/courseKeywords.action")
          .headers(headers_4),
        http("request_11")
          .post(uri1 + "/modules/customer/recentCourseDetail.action")
          .headers(headers_11)
          .formParam("OfferingID", "5576")))
    .pause(4)
    .exec(http("request_12")
      .get("/modules/customer/index.html?action=courseBrowse&CatalogID=5696")
      .headers(headers_0)
      .resources(http("request_13")
        .post(uri1 + "/modules/customer/systemInfo.action")
        .headers(headers_4),
        http("request_14")
          .get(uri1 + "/modules/shop/courseBrowse.shtml??action=courseBrowse&CatalogID=5696")
          .headers(headers_1)
          .check(status.is(304)),
        http("request_15")
          .get(uri1 + "/modules/shop/courseSections.shtml")
          .headers(headers_1)
          .check(status.is(304)),
        http("request_16")
          .get(uri1 + "/modules/shop/courses.shtml")
          .headers(headers_1)
          .check(status.is(304)),
        http("request_17")
          .post(uri1 + "/modules/customer/catalog.action")
          .headers(headers_11)
          .formParam("CatalogID", "5696"),
        http("request_18")
          .post(uri1 + "/modules/customer/searchOfferings.action")
          .headers(headers_11)
          .formParam("", "")
          .formParam("CatalogID", "5696")
          .formParam("startPosition", "0")
          .formParam("pageSize", "100"))
      .check(status.is(304)))
    .pause(9)
    .exec(http("request_19")
      .post("/modules/customer/defaultSections.action")
      .headers(headers_11)
      .formParam("OfferingID", "5576")
      .formParam("CatalogID", "5696")
      .resources(http("request_20")
        .post(uri1 + "/modules/customer/showCart.action")
        .headers(headers_4)))
    .pause(3)
    .exec(http("request_21")
      .get("/modules/customer/index.html?action=section&OfferingID=5576&SectionID=9378")
      .headers(headers_0)
      .resources(http("request_22")
        .post(uri1 + "/modules/customer/systemInfo.action")
        .headers(headers_4),
        http("request_23")
          .get(uri1 + "/modules/shop/section.shtml??action=section&OfferingID=5576&SectionID=9378")
          .headers(headers_1)
          .check(status.is(304)),
        http("request_24")
          .get(uri1 + "/modules/shop/courseOverview.shtml")
          .headers(headers_1)
          .check(status.is(304)),
        http("request_25")
          .get(uri1 + "/modules/shop/cart.shtml")
          .headers(headers_1)
          .check(status.is(304)),
        http("request_26")
          .get(uri1 + "/modules/shop/keywords.shtml")
          .headers(headers_1)
          .check(status.is(304)),
        http("request_27")
          .get(uri1 + "/modules/shop/relatedOfferings.shtml")
          .headers(headers_1)
          .check(status.is(304)),
        http("request_28")
          .post(uri1 + "/modules/customer/defaultSections.action")
          .headers(headers_11)
          .formParam("OfferingID", "5576")
          .formParam("SectionID", "9378"),
        http("request_29")
          .get(uri1 + "/modules/shop/recentViewOfferings.shtml")
          .headers(headers_1)
          .check(status.is(304)),
        http("request_30")
          .post(uri1 + "/modules/customer/showCart.action")
          .headers(headers_4),
        http("request_31")
          .post(uri1 + "/modules/customer/offeringOverview.action")
          .headers(headers_11)
          .formParam("OfferingID", "5576"),
        http("request_32")
          .get(uri1 + "/modules/shop/sectionFactSheet.shtml")
          .headers(headers_1)
          .check(status.is(304)),
        http("request_33")
          .post(uri1 + "/modules/customer/courseKeywords.action")
          .headers(headers_4),
        http("request_34")
          .post(uri1 + "/modules/customer/courseCrossSell.action")
          .headers(headers_11)
          .formParam("OfferingID", "5576"),
        http("request_35")
          .get(uri1 + "/modules/shop/sectionAlternatives.shtml")
          .headers(headers_1)
          .check(status.is(304)),
        http("request_36")
          .post(uri1 + "/modules/customer/recentCourseDetail.action")
          .headers(headers_11)
          .formParam("OfferingID", "5576"))
      .check(status.is(304)))
    .pause(3)
    .exec(http("request_37")
      .post("/modules/customer/addSeatReservation.action")
      .headers(headers_11)
      .formParam("SeatGroupID", "9698")
      .formParam("Quantity", "1"))
    .pause(7)
    .exec(http("request_38")
      .get("/modules/customer/index.html?action=section&OfferingID=5576&SectionID=9378")
      .headers(headers_0)
      .resources(http("request_39")
        .post(uri1 + "/modules/customer/systemInfo.action")
        .headers(headers_4),
        http("request_40")
          .get(uri1 + "/modules/shop/section.shtml??action=section&OfferingID=5576&SectionID=9378")
          .headers(headers_1)
          .check(status.is(304)),
        http("request_41")
          .get(uri1 + "/modules/shop/courseOverview.shtml")
          .headers(headers_1)
          .check(status.is(304)),
        http("request_42")
          .get(uri1 + "/modules/shop/cart.shtml")
          .headers(headers_1)
          .check(status.is(304)),
        http("request_43")
          .get(uri1 + "/modules/shop/relatedOfferings.shtml")
          .headers(headers_1)
          .check(status.is(304)),
        http("request_44")
          .get(uri1 + "/modules/shop/recentViewOfferings.shtml")
          .headers(headers_1)
          .check(status.is(304)),
        http("request_45")
          .get(uri1 + "/modules/shop/keywords.shtml")
          .headers(headers_1)
          .check(status.is(304)),
        http("request_46")
          .post(uri1 + "/modules/customer/defaultSections.action")
          .headers(headers_11)
          .formParam("OfferingID", "5576")
          .formParam("SectionID", "9378"),
        http("request_47")
          .post(uri1 + "/modules/customer/showCart.action")
          .headers(headers_4),
        http("request_48")
          .post(uri1 + "/modules/customer/offeringOverview.action")
          .headers(headers_11)
          .formParam("OfferingID", "5576"),
        http("request_49")
          .post(uri1 + "/modules/customer/courseCrossSell.action")
          .headers(headers_11)
          .formParam("OfferingID", "5576"),
        http("request_50")
          .post(uri1 + "/modules/customer/recentCourseDetail.action")
          .headers(headers_11)
          .formParam("OfferingID", "5576"),
        http("request_51")
          .post(uri1 + "/modules/customer/courseKeywords.action")
          .headers(headers_4),
        http("request_52")
          .get(uri1 + "/modules/shop/sectionFactSheet.shtml")
          .headers(headers_1)
          .check(status.is(304)),
        http("request_53")
          .get(uri1 + "/modules/shop/sectionAlternatives.shtml")
          .headers(headers_1)
          .check(status.is(304)))
      .check(status.is(304)))
    .pause(4)
    .exec(http("request_54")
      .get("/modules/customer/checkout.action")
      .headers(headers_0)
      .resources(http("request_55")
        .post(uri1 + "/modules/customer/systemInfo.action")
        .headers(headers_4),
        http("request_56")
          .get(uri1 + "/modules/customer/validation.shtml??action=validation&validation=addOptionalItem")
          .headers(headers_1)
          .check(status.is(304)),
        http("request_57")
          .post(uri1 + "/modules/customer/validateCart.action")
          .headers(headers_4),
        http("request_58")
          .get(uri1 + "/modules/customer/index.html?action=addOptionalItem")
          .headers(headers_0)
          .check(status.is(304)),
        http("request_59")
          .post(uri1 + "/modules/customer/systemInfo.action")
          .headers(headers_4),
        http("request_60")
          .get(uri1 + "/modules/customer/addOptionalItem.shtml??action=addOptionalItem")
          .headers(headers_1)
          .check(status.is(304)),
        http("request_61")
          .post(uri1 + "/modules/customer/optionalItems.action")
          .headers(headers_4),
        http("request_62")
          .get(uri1 + "/modules/customer/index.html?action=paymentCheckout")
          .headers(headers_0)
          .check(status.is(304)),
        http("request_63")
          .post(uri1 + "/modules/customer/systemInfo.action")
          .headers(headers_4),
        http("request_64")
          .get(uri1 + "/modules/customer/paymentCheckout.shtml??action=paymentCheckout")
          .headers(headers_1)
          .check(status.is(304)),
        http("request_65")
          .post(uri1 + "/modules/customer/showCheckoutCart.action")
          .headers(headers_4),
        http("request_66")
          .get(uri1 + "/modules/account/payment.shtml")
          .headers(headers_1)
          .check(status.is(304)),
        http("request_67")
          .post(uri1 + "/modules/customer/paymentOption.action")
          .headers(headers_4))
      .check(status.is(304)))
    .pause(15)
    .exec(http("request_68")
      .post("/modules/customer/updateCheckoutSeatReservation.action")
      .headers(headers_11)
      .formParam("SeatGroupID", "9698")
      .formParam("Quantity", "1")
      .resources(http("request_69")
        .get(uri1 + "/modules/account/payment.shtml")
        .headers(headers_1)
        .check(status.is(304)),
        http("request_70")
          .post(uri1 + "/modules/customer/paymentOption.action")
          .headers(headers_4)))
    .pause(8)
    .exec(http("request_71")
      .post("/modules/customer/canReserveCartItem.action")
      .headers(headers_4)
      .resources(http("request_72")
        .get(uri1 + "/modules/customer/externalPaymentGateway.action").headers(headers_0).check(headerRegex("Expires","(.*)").saveAs("CartID")),
        http("request_73")
          .post(uri1 + "/modules/customer/systemInfo.action")
          .headers(headers_4),
        http("request_74")
          .get(uri1 + "/modules/customer/paymentStatus.shtml??action=paymentStatus&CartID=${CartID}")
          .headers(headers_1),
        http("request_75")
          .post(uri1 + "/modules/shop/retrieveCart.action")
          .headers(headers_75)
          .formParam("CartID", "${CartID}"),
        http("request_76")
          .get(uri1 + "/modules/authorizePayment.action?PaymentGatewayActivityID=3489")
          .headers(headers_0),
        http("request_77")
          .post(uri1 + "/stub-payment/index.jsp")
          .headers(headers_0)
          .formParam("GATEWAY_POST_URL", "https://localhost:8443/stub-payment/index.jsp")
          .formParam("x_first_name", "Mossaddeque")
          .formParam("x_address", "fgfdgfdg")
          .formParam("x_country", "BD")
          .formParam("x_relay_url", "https://localhost:8443/modules/resumeCheckout.action")
          .formParam("x_amount", "1000.00")
          .formParam("x_last_name", "Mahmood")
          .formParam("x_invoice_num", "3489")
          .formParam("x_zip", "1000")
          .formParam("x_city", "Dhaka")
          .formParam("x_email", "mmahmood.ict.bd@gmail.com")))
    .pause(44)
    .exec(http("request_78")
      .post("/modules/resumeCheckout.action")
      .headers(headers_0)
      .formParam("x_account_number", "4111111111111111")
      .formParam("x_card_type", "Visa")
      .formParam("x_expiration_month", "Dec")
      .formParam("x_expiration_year", "2017")
      .formParam("x_full_name", "Mossaddeque�Mahmood")
      .formParam("x_address", "fgfdgfdg")
      .formParam("x_city", "Dhaka")
      .formParam("x_state", "Dhaka")
      .formParam("x_zip", "1000")
      .formParam("x_country", "BN")
      .formParam("client_id", "")
      .formParam("x_trans_id", "1445953446292")
      .formParam("x_auth_code", "1445953446292")
      .formParam("x_response_code", "1")
      .formParam("x_amount", "1000.00")
      .formParam("x_first_name", "Mossaddeque")
      .formParam("x_last_name", "Mahmood")
      .formParam("x_method", "CC")
      .formParam("x_response_reason_code", "")
      .formParam("x_response_reason_text", "")
      .formParam("x_email", "mmahmood.ict.bd@gmail.com")
      .formParam("GATEWAY_POST_URL", "https://localhost:8443/stub-payment/index.jsp")
      .formParam("x_first_name", "Mossaddeque")
      .formParam("x_address", "fgfdgfdg")
      .formParam("x_relay_url", "https://localhost:8443/modules/resumeCheckout.action")
      .formParam("x_country", "BD")
      .formParam("x_amount", "1000.00")
      .formParam("x_last_name", "Mahmood")
      .formParam("x_invoice_num", "3489")
      .formParam("x_zip", "1000")
      .formParam("x_city", "Dhaka")
      .formParam("x_email", "mmahmood.ict.bd@gmail.com")
      .resources(http("request_79")
        .post(uri1 + "/modules/customer/systemInfo.action")
        .headers(headers_4),
        http("request_80")
          .get(uri1 + "/modules/customer/paymentStatus.shtml??action=paymentStatus&CartID=205&ActivityID=3489")
          .headers(headers_1),
        http("request_81")
          .post(uri1 + "/modules/shop/retrieveCart.action")
          .headers(headers_75)
          .formParam("CartID", "205")))

  setUp(scn.inject(atOnceUsers(1))).protocols(httpProtocol)
}
