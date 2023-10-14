package com.laguipemo.appdesafioarquitecturas.presentation.utils

import android.text.Editable

/**
 * Project: AppDesafioArquitecturas
 * from: com.laguipemo.appdesafioarquitecturas.presentation.utils
 * Created by Lázaro Guillermo Pérez Montoto (chachy) on 14/10/23 at 18:58
 * All rights reserved 2023
 *
 * https://github.com/laguipemo/
 **/


fun String.toEditable(): Editable = Editable.Factory().newEditable(this)