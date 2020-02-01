package com.sandisetiawan444.base

import android.app.Activity
import com.sandisetiawan444.base.ext.navigatorImplicit

/**
 * Created by Sandi on 31/01/2020.
 */

/** Setting */
private const val PACKAGE_SETTING_PAGE = "com.sandisetiawan444.setting.ui.SettingsActivity"

/**
 * Setting
 */
fun Activity.openSettingPage() {
    navigatorImplicit(packageName, PACKAGE_SETTING_PAGE)
}