package com.example.quizapp

import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.core.content.ContextCompat
import java.lang.reflect.Type

class QuizzQuestionActivity : AppCompatActivity(), View.OnClickListener  {

    private lateinit var progress_bar: ProgressBar
    private lateinit var tv_progress:TextView
    private lateinit var tv_question: TextView
    private lateinit var iv_image:ImageView
    private lateinit var tv_optionOne: TextView
    private lateinit var tv_optionTwo: TextView
    private lateinit var tv_optionThree: TextView
    private lateinit var tv_optionFour: TextView
    private lateinit var btn_submit: Button

    private  var mCurrentPosition: Int = 1
    private var mQuestionList: ArrayList<Question>? = null
    private var mSelectedOptionPosition: Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quizz_question)

        progress_bar = findViewById(R.id.progress_bar)
        tv_progress = findViewById(R.id.tv_progress)
        tv_question = findViewById(R.id.tv_question)
        iv_image = findViewById(R.id.iv_image)

        tv_optionOne = findViewById(R.id.tv_optionOne)
        tv_optionTwo = findViewById(R.id.tv_optionTwo)
        tv_optionThree = findViewById(R.id.tv_optionThree)
        tv_optionFour = findViewById(R.id.tv_optionFour)

        btn_submit = findViewById(R.id.btn_submit)

         mQuestionList = Constants.getQuestions()

        setQuestion()

        tv_optionOne.setOnClickListener(this)
        tv_optionTwo.setOnClickListener(this)
        tv_optionThree.setOnClickListener(this)
        tv_optionFour.setOnClickListener(this)

        btn_submit.setOnClickListener(this)



    }

    private fun setQuestion(){

        val question = mQuestionList!![mCurrentPosition - 1]

        defaultOptionsView()

        if(mCurrentPosition == mQuestionList!!.size){
            btn_submit.text = "Finish"
        }else{
            btn_submit.text = "Submit"
        }

        progress_bar.progress = mCurrentPosition
        tv_progress.text = "$mCurrentPosition" + "/" + progress_bar.max

        tv_question.text = question!!.question

        iv_image.setImageResource(question.image)

        tv_optionOne.text = question.optionOne
        tv_optionTwo.text = question.optionTwo
        tv_optionThree.text = question.optionThree
        tv_optionFour.text = question.optionFour
    }

    private fun defaultOptionsView(){
        val options = ArrayList<TextView>()
        options.add(0, tv_optionOne)
        options.add(1, tv_optionTwo)
        options.add(2, tv_optionThree)
        options.add(3, tv_optionFour)


        for (option in options){
            option.setTextColor(Color.parseColor("#7A8089"))

            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                this,
                R.drawable.default_option_border_bg
            )
        }
    }

    override fun onClick(p0: View?) {
        when(p0?.id){
            R.id.tv_optionOne ->{
                selectedOptionView(tv_optionOne, 1)
        }
            R.id.tv_optionTwo ->{
                selectedOptionView(tv_optionTwo, 2)
            }

            R.id.tv_optionThree ->{
                selectedOptionView(tv_optionThree, 3)
            }

            R.id.tv_optionFour ->{
                selectedOptionView(tv_optionFour, 4)
            }

            R.id.btn_submit ->{
                if(mSelectedOptionPosition == 0){
                    mCurrentPosition++

                    when{
                        mCurrentPosition <= mQuestionList!!.size -> {
                            setQuestion()
                        }else ->{
                            Toast.makeText(this, "You have completed the Quiz", Toast.LENGTH_SHORT).show()
                        }
                    }

                }else{
                    val question = mQuestionList?.get(mCurrentPosition - 1)

                    if(question!!.correctAnswer != mSelectedOptionPosition){
                        answerView(mSelectedOptionPosition, R.drawable.wrong_option_border)
                    }
                    answerView(question.correctAnswer, R.drawable.correct_option_border)

                    if (mCurrentPosition == mQuestionList!!.size){
                        btn_submit.text = "Finish"
                    }else{
                        btn_submit.text = "Go to next Question"
                    }
                    mSelectedOptionPosition = 0
                }
            }
        }
    }

    private fun answerView(answer: Int, drawableView: Int){
        when(answer){
            1 ->{
                tv_optionOne.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }
            2 ->{
                tv_optionTwo.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }
            3 ->{
                tv_optionThree.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }
            4 ->{
                tv_optionFour.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }
        }
    }

    private fun selectedOptionView(tv: TextView, selectedOptionNumber: Int){
        defaultOptionsView()
        mSelectedOptionPosition = selectedOptionNumber

        tv.setTextColor(Color.parseColor("#363A43"))

        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(
            this,
            R.drawable.selected_option_border
        )
    }
}