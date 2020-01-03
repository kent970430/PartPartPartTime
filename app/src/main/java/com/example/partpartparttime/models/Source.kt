package com.example.partpartparttime.models

class Source {
    companion object{

        fun createDataSet(): ArrayList<EventPost>{
            val list = ArrayList<EventPost>()
            list.add(
                EventPost(
                    "Title 1",
                    "Description 1",
                    "Image  File",
                    "Organization name"
                )
            )

            list.add(
                EventPost(
                    "Title 2",
                    "Description 2",
                    "Image  File",
                    "Organization name"
                )
            )

            list.add(
                EventPost(
                    "Title 3",
                    "Description 3",
                    "Image  File",
                    "Organization name"
                )
            )

            list.add(
                EventPost(
                    "Title 4",
                    "Description 4",
                    "Image  File",
                    "Organization name"
                )
            )

            list.add(
                EventPost(
                    "Title 5",
                    "Description 5",
                    "Image  File",
                    "Organization name"
                )
            )

            list.add(
                EventPost(
                    "Title 6",
                    "Description 6",
                    "Image  File",
                    "Organization name"
                )
            )

            return list
        }
    }
}