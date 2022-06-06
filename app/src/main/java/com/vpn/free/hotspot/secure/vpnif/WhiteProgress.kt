package com.vpn.free.hotspot.secure.vpnif

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_white_progress.*
import kotlin.random.Random

class WhiteProgress : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_white_progress)

        refreshButton.setOnClickListener {
            randomizePositions()
        }

        parentCoordinatorLayout.addDraggableChild(draggableCard1)
        parentCoordinatorLayout.addDraggableChild(draggableCard2)
        parentCoordinatorLayout.addDraggableChild(draggableCard3)
        parentCoordinatorLayout.addDraggableChild(draggableCard4)

        parentCoordinatorLayout.setViewDragListener(object : DraggableCoordinatorLayout.ViewDragListener {
            override fun onViewCaptured(view: View, i: Int) {

                when (view.id) {
                    R.id.draggableCard1 -> draggableCard1.isDragged = true
                    R.id.draggableCard2 -> draggableCard2.isDragged = true
                    R.id.draggableCard3 -> draggableCard3.isDragged = true
                    R.id.draggableCard4 -> draggableCard4.isDragged = true
                }
            }

            override fun onViewReleased(view: View, v: Float, v1: Float) {

                when (view.id) {
                    R.id.draggableCard1 -> draggableCard1.isDragged = false
                    R.id.draggableCard2 -> draggableCard2.isDragged = false
                    R.id.draggableCard3 -> draggableCard3.isDragged = false
                    R.id.draggableCard4 -> draggableCard4.isDragged = false
                }
            }
        })
    }

    private fun random() = Random.nextInt(-300, 300).toFloat()

    private fun randomizePositions() {
        draggableCard1.animate()
            .translationX(random())
            .translationY(random())
            .setDuration(100)
            .start()

        draggableCard2.animate()
            .translationX(random())
            .translationY(random())
            .setDuration(100)
            .start()

        draggableCard3.animate()
            .translationX(random())
            .translationY(random())
            .setDuration(100)
            .start()

        draggableCard4.animate()
            .translationX(random())
            .translationY(random())
            .setDuration(100)
            .start()
    }

}