package br.com.mystudies.scala.exercises

/**
 * Improve the Counter class in Section 5.1 , “Simple Classes and Parameterless Methods,”
 * on page 49 so that it doesn’t turn negative at Int.MaxValue .
 */
object Ex01 extends App {
  
  val counter = new Counter(10)
  counter.increment()
  
  println(counter.current)
  
 
  class Counter(private var value: Int ){
    def increment(){
      if( value + 1 <= Int.MaxValue){
        value += 1
      }
    }
    def current = value
  }
   
}