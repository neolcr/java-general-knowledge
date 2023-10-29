package com.neol.nulltreatment

fun main(){
    // Null treament part 2
    val str: String? = "This is not null"
    val str1 = str?.uppercase();

    val str2: String? = null
    //val str3 = str2!!.uppercase(); // throws an exception because I want it

    // we can use let to call the fun
    val str3: String? = "This not null"
    str3?.let { printText(it) }
    str2?.let { printText(it) }

    // == is null safe in kotlin
    val str4: String? = null
    val str5 = "This isn't nullable"
    println(str4 == str5)

    // Array of nulls
    println("Array of nulls")
    val nullableInts = arrayOfNulls<Int>(5)
    for (i in nullableInts){
        println(i)
    }


}

fun printText(text: String){
    println("I got $text")
}