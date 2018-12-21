package com.spaceon.spaceonmapplugin;

import io.flutter.plugin.common.PluginRegistry.Registrar;

/** SpaceonMapPlugin */
public class SpaceonMapPlugin {
  /** Plugin registration. */
  public static void registerWith(Registrar registrar) {
    /*final MethodChannel channel = new MethodChannel(registrar.messenger(), "spaceon_map_plugin");
    channel.setMethodCallHandler(new SpaceonMapPlugin());*/
    registrar
            .platformViewRegistry()
            .registerViewFactory(
                    "plugins.spaceon/mapview", new MapViewFactory(registrar.messenger()));
  }

  /*@Override
  public void onMethodCall(MethodCall call, Result result) {
    if (call.method.equals("getPlatformVersion")) {
      result.success("Android " + android.os.Build.VERSION.RELEASE);
    } else {
      result.notImplemented();
    }
  }*/
}
