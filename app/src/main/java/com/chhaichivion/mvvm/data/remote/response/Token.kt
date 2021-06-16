package com.chhaichivion.mvvm.data.remote.response

import androidx.annotation.Keep


/**
 * Copyright (c) PRASAC MFI, Ltd. All rights reserved. (https://www.prasac.com.kh/)
 * Author	: Chhai Chivon (chivon.chhai@prasac.com.kh) on 6/16/21.
 * Position : Senior Application Development Officer
 */

@Keep
data class Token(
    var access_token: String? = null,
    var refresh_token: String? = null,
    var token_type: String? = null,
    var expires_in: Long = 0,
    var scope: String? = null,
    var user: String? = null
)