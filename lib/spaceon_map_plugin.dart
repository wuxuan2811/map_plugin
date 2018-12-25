import 'dart:async';

import 'package:flutter/services.dart';

class SpaceonMapPlugin {
  final MethodChannel _channel;

  SpaceonMapPlugin(int id)
      : _channel = MethodChannel('plugins.spaceon/mapview');

  Future<void> zoomIn() async {
    return _channel.invokeMethod('zoomIn');
  }

  Future<void> zoomOut() async {
    return _channel.invokeMethod('zoomOut');
  }

  Future center(double lat, double lon) async{
    Map map = Map();
    map['Lat'] = lat;
    map['Lon'] = lon;
    return _channel.invokeMethod('center', map);
  }
}
