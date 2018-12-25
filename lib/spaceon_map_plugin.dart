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
}
