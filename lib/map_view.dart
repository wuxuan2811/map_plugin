import 'package:flutter/foundation.dart';
import 'package:flutter/material.dart';
import 'spaceon_map_plugin.dart';

typedef void TextViewCreatedCallback(SpaceonMapPlugin controller);

class MapView extends StatefulWidget {
  const MapView({
    Key key,
    this.onTextViewCreated,
  }) : super(key: key);

  final TextViewCreatedCallback onTextViewCreated;

  @override
  State<StatefulWidget> createState() => _MapViewState();
}

class _MapViewState extends State<MapView> {
  @override
  Widget build(BuildContext context) {
    if (defaultTargetPlatform == TargetPlatform.android) {
      return AndroidView(
        viewType: 'plugins.spaceon/mapview',
        onPlatformViewCreated: _onPlatformViewCreated,
      );
    }
    return Text(
        '$defaultTargetPlatform is not yet supported by the text_view plugin');
  }

  void _onPlatformViewCreated(int id) {
    if (widget.onTextViewCreated == null) {
      return;
    }
    widget.onTextViewCreated(new SpaceonMapPlugin(id));
  }
}
