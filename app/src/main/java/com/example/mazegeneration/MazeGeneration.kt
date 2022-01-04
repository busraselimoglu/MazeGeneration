package com.example.mazegeneration

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.util.Log
import android.view.View
import kotlin.properties.Delegates

class MazeGeneration : View {
    private val cols = 7
    private val rows = 10

    private var cellSize by Delegates.notNull<Float>()
    private var hMargin by Delegates.notNull<Float>()
    private var vMargin by Delegates.notNull<Float>()

    //private lateinit var cells: Array<Array<Cell>>
    //var cells = Cell[cols][rows]
    private var cells = arrayOf<Array<Cell>>()

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        createMaze()
    }


    private val wallPaint = Paint().apply {
        style = Paint.Style.STROKE
        strokeWidth = 4F // wall thickness
        color = Color.BLACK
        Log.d("bk", "wallPaint")
    }

    private fun createMaze() {
        //cells = Cell[cols][rows]
        cells[cols][rows]

        Log.d("bk", "createMaze")
        for (x in 0 until cols) {
            for (y in 0 until rows) {
                Log.d("bk", "createMaze/Cell")
                cells[x][y] = Cell(x,y)
                //cells[x][y]
            }
        }

    }

    override fun onDraw(canvas: Canvas) {
        //super.onDraw(canvas)
        canvas.drawColor(Color.GREEN)

        Log.d("bk", "onDraw")
        val width = width
        val height = height

        val widthHeight: Double = (width / height).toDouble()
        val colsRows: Double = (cols / rows).toDouble()

        cellSize = if (widthHeight < colsRows) {
            //vertical
            (width / (cols + 1)).toFloat()
        } else {
            // horizontal
            (height / (rows + 1)).toFloat()
        }

        hMargin = (width - cols * cellSize) / 2
        vMargin = (height - rows * cellSize) / 2

        canvas.translate(hMargin, vMargin)

        for (x in 0 until cols) {
            for (y in 0 until rows) {
                // draw topWall
                if (cells[x][y].topWall) {
                    canvas.drawLine(
                        x * cellSize,
                        y * cellSize,
                        (x + 1) * cellSize,
                        y * cellSize,
                        wallPaint
                    )
                }
                // draw leftWall
                if (cells[x][y].leftWall) {
                    canvas.drawLine(
                        x * cellSize,
                        y * cellSize,
                        x * cellSize,
                        (y + 1) * cellSize,
                        wallPaint
                    )
                }
                // draw bottomWall
                if (cells[x][y].bottomWall) {
                    canvas.drawLine(
                        x * cellSize,
                        (y + 1) * cellSize,
                        (x + 1) * cellSize,
                        (y + 1) * cellSize,
                        wallPaint
                    )
                }
                // draw rightWall
                if (cells[x][y].rightWall) {
                    canvas.drawLine(
                        (x + 1) * cellSize,
                        y * cellSize,
                        (x + 1) * cellSize,
                        (y + 1) * cellSize,
                        wallPaint
                    )
                }
            }
        }
    }


}