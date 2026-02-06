package com.px_esport.product

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.tencent.kuikly.compose.coil3.rememberAsyncImagePainter
import com.tencent.kuikly.compose.foundation.Image
import com.tencent.kuikly.compose.foundation.background
import com.tencent.kuikly.compose.foundation.layout.Box
import com.tencent.kuikly.compose.foundation.layout.Column
import com.tencent.kuikly.compose.foundation.layout.Row
import com.tencent.kuikly.compose.foundation.layout.Spacer
import com.tencent.kuikly.compose.foundation.layout.fillMaxSize
import com.tencent.kuikly.compose.foundation.layout.height
import com.tencent.kuikly.compose.foundation.layout.padding
import com.tencent.kuikly.compose.foundation.layout.size
import com.tencent.kuikly.compose.foundation.shape.RoundedCornerShape
import com.tencent.kuikly.compose.material3.Text
import com.tencent.kuikly.compose.setContent
import com.tencent.kuikly.compose.ui.Alignment
import com.tencent.kuikly.compose.ui.Modifier
import com.tencent.kuikly.compose.ui.graphics.Brush
import com.tencent.kuikly.compose.ui.graphics.Color
import com.tencent.kuikly.compose.ui.platform.LocalActivity
import com.tencent.kuikly.compose.ui.text.TextStyle
import com.tencent.kuikly.compose.ui.toComposeColor
import com.tencent.kuikly.compose.ui.unit.dp
import com.tencent.kuikly.compose.ui.unit.sp
import com.tencent.kuikly.core.annotations.Page
import com.tencent.kuikly.core.module.RouterModule
import com.tencent.kuikly.core.module.SharedPreferencesModule
import com.tencent.kuikly.core.nvi.serialization.json.JSONObject
import com.tencent.kuikly.core.pager.Pager
import com.tencent.kuikly.core.utils.urlParams
import com.px_esport.product.base.BasePager
import com.px_esport.product.base.bridgeModule
import com.px_esport.product.base.Utils
import com.tencent.kuikly.compose.foundation.layout.Arrangement
import com.tencent.kuikly.compose.foundation.layout.PaddingValues
import com.tencent.kuikly.compose.foundation.layout.fillMaxWidth
import com.tencent.kuikly.compose.foundation.lazy.LazyColumn
import com.tencent.kuikly.compose.foundation.lazy.rememberLazyListState

@Page("router", supportInLocal = true)
internal class ComposeRoutePager : BasePager() {

    override fun willInit() {
        super.willInit()
        setContent {
            ComposeRouteImpl()
        }
    }

    companion object {
        const val PLACEHOLDER = "输入pageName（不区分大小写）"
        const val CACHE_KEY = "router_last_input_key2"
        const val LOGO = "https://vfiles.gtimg.cn/wuji_dashboard/wupload/xy/starter/62394e19.png"
        const val JUMP_TEXT = "跳转"
        const val TEXT_KEY = "text"
        const val TITLE = "Kuikly页面路由"
        const val AAR_MODE_TIP = "如：router 或者 router&key=value （&后面为页面参数）"
    }
}

@Composable
internal fun ComposeRouteImpl() {
    val state = rememberLazyListState()
    Column {
        // LazyColumn 示例
        Text("LazyListLayoutInfo 测试:")
        LazyColumn(
            state = state,
            modifier =
                Modifier
                    .padding(top = 100.dp)
                    .fillMaxSize()
                    .background(Color.LightGray),
            contentPadding = PaddingValues(vertical = 20.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
        ) {
            stickyHeader {
                Box(modifier = Modifier.fillMaxWidth().height(20.dp).background(Color.Red)){
                    Text("header")
                }
            }
            items(220) { index ->
                Box(
                    modifier =
                        Modifier
                            .fillMaxWidth()
                            .height(20.dp)
                            .background(Color.Blue)
                            .padding(4.dp),
                    contentAlignment = Alignment.Center
                ) {
//                    Text(
//                        "Item $index",
//                        color = Color.White,
//                    )
                }
            }
        }
    }
}