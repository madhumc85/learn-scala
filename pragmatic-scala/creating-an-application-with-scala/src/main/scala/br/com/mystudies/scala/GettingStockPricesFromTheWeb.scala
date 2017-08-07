

package br.com.mystudies.scala

import java.net.URLEncoder._
import java.time.LocalDate._
import java.time.format.DateTimeFormatter._
import java.util.Locale._
import scala.io.Source
import scala.xml.XML
import java.time.temporal.ChronoUnit
import java.time.LocalDate

object GettingStockPricesFromTheWeb extends App {

  val symbolsAndUnits = StockLoader load


  println(ChronoUnit.DAYS.between(now(), LocalDate.of(2018, 8, 1)))

}







object StockPriceFinder{
  def getLatestClosingPrice(symbol: String) ={
    val url = s"http://www.google.com/finance/historical?q=NASDAQ:${symbol}&startdate=${yesterday}&output=csv"
    val data = Source.fromURL(url).mkString
    val closingPrice = data.split("\n")(1).split(",")(4).toDouble
    closingPrice
  }
  private def yesterday = encode(now.minusDays(1).format(ofPattern("MMM d, yyyy",US)))
}


object StockLoader{
  def load = {
    val stocksAndUnits = XML.loadFile("stocks.xml")
    ( Map[String,Int]() /: (stocksAndUnits \ "symbol") ){
      (map, symbolNode) =>
        val ticker = (symbolNode \ "@ticker").toString
        val units = (symbolNode \ "units").text.toInt
        map + (ticker -> units)
    }
  }
}


