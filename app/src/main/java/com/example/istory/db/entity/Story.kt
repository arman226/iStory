package com.example.istory.db.entity

import androidx.room.*
import com.example.istory.constants.TableNames
import com.example.istory.db.helpers.Converters
import java.util.*

@Entity(tableName = TableNames.STORY_DATA_TABLE)
data class Story (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name="story_id")
    var id :Int,
    @ColumnInfo(name="story_title")
    var title:String,
    @ColumnInfo(name="story_content")
    var content:String,
    @ColumnInfo(name="date")
    var date:Date,
    @ColumnInfo(name="active")
    var active:Boolean
)