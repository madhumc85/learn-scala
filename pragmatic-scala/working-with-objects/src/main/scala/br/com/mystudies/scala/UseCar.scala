package br.com.mystudies.scala

import java.lang.Math._

// see Car.java for comparison
class Car(val year: Int) {
  private var milesDriven = 0
  def miles = milesDriven
  def drive(distance: Int) = milesDriven += abs(distance)
}











// USING THE CLASS
object UseCar extends App {

  val car = new Car(2015)

  println(s"Car made in year ${car.year}")
  println(s"Miles driven ${car.miles}")
  println(s"Drive for 10 miles")
  car drive 10
  println(s"Miles driven ${car.miles}")
}
