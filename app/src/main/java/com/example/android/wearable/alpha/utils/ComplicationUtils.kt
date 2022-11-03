/*
 * Copyright 2020 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.wearable.alpha.utils

import android.content.Context
import android.graphics.Color
import android.graphics.RectF
import androidx.annotation.ColorInt
import androidx.core.content.ContextCompat
import androidx.wear.watchface.CanvasComplicationFactory
import androidx.wear.watchface.ComplicationSlot
import androidx.wear.watchface.ComplicationSlotsManager
import androidx.wear.watchface.complications.ComplicationSlotBounds
import androidx.wear.watchface.complications.DefaultComplicationDataSourcePolicy
import androidx.wear.watchface.complications.SystemDataSources
import androidx.wear.watchface.complications.data.ComplicationType
import androidx.wear.watchface.complications.rendering.CanvasComplicationDrawable
import androidx.wear.watchface.complications.rendering.ComplicationDrawable
import androidx.wear.watchface.complications.rendering.ComplicationStyle
import androidx.wear.watchface.style.CurrentUserStyleRepository
import com.example.android.wearable.alpha.R
import com.example.android.wearable.alpha.data.watchface.WHITE_COLOR_STYLE_ID

// Information needed for complications.
// Creates bounds for the locations of both right and left complications. (This is the
// location from 0.0 - 1.0.)
// Both left and right complications use the same top and bottom bounds.

private val COMPLICATION1_Rect = RectF(0.162f,0.384f,0.362f,0.584f)
private val COMPLICATION2_Rect = RectF(0.39f,0.62f,0.61f,0.84f)
private val COMPLICATION3_Rect = RectF(0.643f,0.384f,0.843f,0.584f)
private val COMPLICATION4_Rect = RectF(0.425f,0.262f,0.575f,0.412f)

private val COMPLICATION5_Rect = RectF(0.15f,0.15f,0.2f,0.2f)
private val COMPLICATION6_Rect = RectF(0.8f,0.15f,0.85f,0.2f)
private val COMPLICATION7_Rect = RectF(0.8f,0.8f,0.85f,0.85f)
private val COMPLICATION8_Rect = RectF(0.15f,0.8f,0.2f,0.85f)
private const val DEFAULT_COMPLICATION_STYLE_DRAWABLE_ID = R.drawable.complication_red_style

// Unique IDs for each complication. The settings activity that supports allowing users
// to select their complication data provider requires numbers to be >= 0.
internal const val COMPLICATION1_ID = 100
internal const val COMPLICATION2_ID = 101
internal const val COMPLICATION3_ID = 102
internal const val COMPLICATION4_ID = 103
internal const val COMPLICATION5_ID = 104
internal const val COMPLICATION6_ID = 105
internal const val COMPLICATION7_ID = 106
internal const val COMPLICATION8_ID = 107
/**
 * Represents the unique id associated with a complication and the complication types it supports.
 */
sealed class ComplicationConfig(val id: Int, val supportedTypes: List<ComplicationType>) {
    object C1 : ComplicationConfig(
        COMPLICATION1_ID,
        listOf(
            ComplicationType.RANGED_VALUE,
            ComplicationType.MONOCHROMATIC_IMAGE,
            ComplicationType.SHORT_TEXT,
            ComplicationType.SMALL_IMAGE
        )
    )
    object C2 : ComplicationConfig(
        COMPLICATION2_ID,
        listOf(
            ComplicationType.RANGED_VALUE,
            ComplicationType.MONOCHROMATIC_IMAGE,
            ComplicationType.SHORT_TEXT,
            ComplicationType.SMALL_IMAGE
        )
    )
    object C3 : ComplicationConfig(
        COMPLICATION3_ID,
        listOf(
            ComplicationType.RANGED_VALUE,
            ComplicationType.MONOCHROMATIC_IMAGE,
            ComplicationType.SHORT_TEXT,
            ComplicationType.SMALL_IMAGE
        )
    )
    object C4 : ComplicationConfig(
        COMPLICATION4_ID,
        listOf(
            ComplicationType.RANGED_VALUE,
            ComplicationType.MONOCHROMATIC_IMAGE,
            ComplicationType.SHORT_TEXT,
            ComplicationType.SMALL_IMAGE
        )
    )
    object C5 : ComplicationConfig(
        COMPLICATION5_ID,
        listOf(
            ComplicationType.RANGED_VALUE,
            ComplicationType.MONOCHROMATIC_IMAGE,
            ComplicationType.SHORT_TEXT,
            ComplicationType.SMALL_IMAGE
        )
    )
    object C6 : ComplicationConfig(
        COMPLICATION6_ID,
        listOf(
            ComplicationType.RANGED_VALUE,
            ComplicationType.MONOCHROMATIC_IMAGE,
            ComplicationType.SHORT_TEXT,
            ComplicationType.SMALL_IMAGE
        )
    )
    object C7 : ComplicationConfig(
        COMPLICATION7_ID,
        listOf(
            ComplicationType.RANGED_VALUE,
            ComplicationType.MONOCHROMATIC_IMAGE,
            ComplicationType.SHORT_TEXT,
            ComplicationType.SMALL_IMAGE
        )
    )
    object C8 : ComplicationConfig(
        COMPLICATION8_ID,
        listOf(
            ComplicationType.RANGED_VALUE,
            ComplicationType.MONOCHROMATIC_IMAGE,
            ComplicationType.SHORT_TEXT,
            ComplicationType.SMALL_IMAGE
        )
    )
}

// Utility function that initializes default complication slots (left and right).
fun createComplicationSlotManager(
    context: Context,
    currentUserStyleRepository: CurrentUserStyleRepository,
    drawableId: Int = DEFAULT_COMPLICATION_STYLE_DRAWABLE_ID
): ComplicationSlotsManager {
    val defaultCanvasComplicationFactory =
        CanvasComplicationFactory { watchState, listener ->
            CanvasComplicationDrawable(
                ComplicationDrawable.getDrawable(context, drawableId)!!,
                watchState,
                listener
            )
        }
    val complication1 = ComplicationSlot.createRoundRectComplicationSlotBuilder(
        id = ComplicationConfig.C1.id,
        canvasComplicationFactory = defaultCanvasComplicationFactory,
        supportedTypes = ComplicationConfig.C1.supportedTypes,
        defaultDataSourcePolicy = DefaultComplicationDataSourcePolicy(
            SystemDataSources.DATA_SOURCE_DAY_OF_WEEK,
            ComplicationType.SHORT_TEXT
        ),
        bounds = ComplicationSlotBounds(
            COMPLICATION1_Rect

        )
    ).build()
    val complication2 = ComplicationSlot.createRoundRectComplicationSlotBuilder(
        id = ComplicationConfig.C2.id,
        canvasComplicationFactory = defaultCanvasComplicationFactory,
        supportedTypes = ComplicationConfig.C2.supportedTypes,
        defaultDataSourcePolicy = DefaultComplicationDataSourcePolicy(
            SystemDataSources.DATA_SOURCE_DAY_OF_WEEK,
            ComplicationType.SHORT_TEXT
        ),
        bounds = ComplicationSlotBounds(
            COMPLICATION2_Rect
        )
    ).build()
    val complication3 = ComplicationSlot.createRoundRectComplicationSlotBuilder(
        id = ComplicationConfig.C3.id,
        canvasComplicationFactory = defaultCanvasComplicationFactory,
        supportedTypes = ComplicationConfig.C3.supportedTypes,
        defaultDataSourcePolicy = DefaultComplicationDataSourcePolicy(
            SystemDataSources.DATA_SOURCE_DAY_OF_WEEK,
            ComplicationType.SHORT_TEXT
        ),
        bounds = ComplicationSlotBounds(
            COMPLICATION3_Rect
        )
    ).build()
    val complication4 = ComplicationSlot.createRoundRectComplicationSlotBuilder(
        id = ComplicationConfig.C4.id,
        canvasComplicationFactory = defaultCanvasComplicationFactory,
        supportedTypes = ComplicationConfig.C4.supportedTypes,
        defaultDataSourcePolicy = DefaultComplicationDataSourcePolicy(
            SystemDataSources.DATA_SOURCE_DAY_OF_WEEK,
            ComplicationType.SHORT_TEXT
        ),
        bounds = ComplicationSlotBounds(
            COMPLICATION4_Rect
        )
    ).build()
    val complication5 = ComplicationSlot.createRoundRectComplicationSlotBuilder(
        id = ComplicationConfig.C5.id,
        canvasComplicationFactory = defaultCanvasComplicationFactory,
        supportedTypes = ComplicationConfig.C5.supportedTypes,
        defaultDataSourcePolicy = DefaultComplicationDataSourcePolicy(
            SystemDataSources.DATA_SOURCE_DAY_OF_WEEK,
            ComplicationType.SHORT_TEXT
        ),
        bounds = ComplicationSlotBounds(
            COMPLICATION5_Rect
        )
    ).build()
    val complication6 = ComplicationSlot.createRoundRectComplicationSlotBuilder(
        id = ComplicationConfig.C6.id,
        canvasComplicationFactory = defaultCanvasComplicationFactory,
        supportedTypes = ComplicationConfig.C6.supportedTypes,
        defaultDataSourcePolicy = DefaultComplicationDataSourcePolicy(
            SystemDataSources.DATA_SOURCE_DAY_OF_WEEK,
            ComplicationType.SHORT_TEXT
        ),
        bounds = ComplicationSlotBounds(
            COMPLICATION6_Rect
        )
    ).build()
    val complication7 = ComplicationSlot.createRoundRectComplicationSlotBuilder(
        id = ComplicationConfig.C7.id,
        canvasComplicationFactory = defaultCanvasComplicationFactory,
        supportedTypes = ComplicationConfig.C7.supportedTypes,
        defaultDataSourcePolicy = DefaultComplicationDataSourcePolicy(
            SystemDataSources.DATA_SOURCE_DAY_OF_WEEK,
            ComplicationType.SHORT_TEXT
        ),
        bounds = ComplicationSlotBounds(
            COMPLICATION7_Rect
        )
    ).build()
    val complication8 = ComplicationSlot.createRoundRectComplicationSlotBuilder(
        id = ComplicationConfig.C8.id,
        canvasComplicationFactory = defaultCanvasComplicationFactory,
        supportedTypes = ComplicationConfig.C8.supportedTypes,
        defaultDataSourcePolicy = DefaultComplicationDataSourcePolicy(
            SystemDataSources.DATA_SOURCE_DAY_OF_WEEK,
            ComplicationType.SHORT_TEXT
        ),
        bounds = ComplicationSlotBounds(
            COMPLICATION8_Rect
        )
    ).build()
    return ComplicationSlotsManager(
        listOf(complication1,complication2,complication3,complication4,complication5,complication6,complication7,complication8),
        currentUserStyleRepository
    )
}
