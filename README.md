# DoubleIcon

##动态更换APP Icon

##原理

  ` // 决定应用程序最先启动的Activity 
    android.intent.action.MAIN  
    // 决定应用程序是否显示在程序列表里 
    android.intent.category.LAUNCHER `

  ` <activity-alias
       android:name=".DoubleOne"
       android:enabled="false"
       android:icon="@mipmap/ic_launcher11"
       android:label="双11"
       android:targetActivity=".MainActivity">
       <intent-filter>
           <action android:name="android.intent.action.MAIN"/>

           <category android:name="android.intent.category.LAUNCHER"/>
       </intent-filter>
     </activity-alias> `

  添加多个`activity-alias` 之后利用`PackageManager.setComponentEnabledSetting`方法 
  
  然后`PackageManager.COMPONENT_ENABLED_STATE_ENABLED` 
  
  以及`PackageManager.COMPONENT_ENABLED_STATE_DISABLED` 
  
  这两个标志和对应的`ComponentName`，就可以控制一个组件的是否启用。
  
