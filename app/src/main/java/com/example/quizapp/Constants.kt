package com.example.quizapp

object Constants{

    fun getQuestions(): ArrayList<Question>{
        val questionsList = ArrayList<Question>()

        val que1 = Question(1, "What country does this flag belong to?", R.drawable.ic_flag_of_argentina,
            "Argentina",
            "Uzbekistan",
            "Russian",
            "USA",
            1
        )
        questionsList.add(que1)

        val que2 = Question(2, "What country does this flag belong to?", R.drawable.ic_flag_of_australia,
            "Argentina",
            "Australia",
            "Russian",
            "USA",
            2
        )
        questionsList.add(que2)

        val que3 = Question(3, "What country does this flag belong to?", R.drawable.ic_flag_of_belgium,
            "Belgium",
            "Uzbekistan",
            "Argentina",
            "USA",
            1
        )
        questionsList.add(que3)

        val que4 = Question(4, "What country does this flag belong to?", R.drawable.ic_flag_of_brazil,
            "Russian",
            "England",
            "Brazil",
            "Africa",
            3
        )
        questionsList.add(que4)

        val que5 = Question(5, "What country does this flag belong to?", R.drawable.ic_flag_of_denmark,
            "Argentina",
            "Uzbekistan",
            "Russian",
            "Denmark",
            4
        )
        questionsList.add(que5)

        val que6 = Question(6, "What country does this flag belong to?", R.drawable.ic_flag_of_fiji,
            "Fiji",
            "Uzbekistan",
            "Germany",
            "Kazakhstan",
            1
        )
        questionsList.add(que6)

        val que7 = Question(7, "What country does this flag belong to?", R.drawable.ic_flag_of_germany,
            "Argentina",
            "Uzbekistan",
            "Germany",
            "USA",
            3
        )
        questionsList.add(que7)

        val que8 = Question(8, "What country does this flag belong to?", R.drawable.ic_flag_of_india,
            "Argentina",
            "Uzbekistan",
            "India",
            "USA",
            3
        )
        questionsList.add(que8)

        val que9 = Question(9, "What country does this flag belong to?", R.drawable.ic_flag_of_kuwait,
            "Argentina",
            "Uzbekistan",
            "Kuwait",
            "USA",
            3
        )
        questionsList.add(que9)

        val que10 = Question(10, "What country does this flag belong to?", R.drawable.ic_flag_of_new_zealand,
            "Argentina",
            "New Zealand",
            "Russian",
            "USA",
            2
        )
        questionsList.add(que10)

        return questionsList
    }

}