package com.example.mazegeneration

class Cell(var col:Int, var row: Int){

    var topWall: Boolean = true
    var leftWall: Boolean = true
    var bottomWall: Boolean = true
    var rightWall: Boolean = true
    var visited: Boolean = false

    /*companion object{
        var col: Int = 0
        var row: Int = 0
        operator fun get(cols: Int) {
            this.col =cols

        }
        operator fun get(rows: Int) {
            this.row = rows
        }
    }*/



    /*var col: Int = _col
    set(value) {
        col = value
        field = value
    }*/

    /*var col =0
    var row=0

    operator fun get(col: Int,row: Int) {
        this.col
        this.row
    }*/



}


