// automatically generated, do not modify

package com.example.flatbufferdemo;

import java.nio.*;
import java.lang.*;
import java.util.*;
import com.google.flatbuffers.*;

public final class Notebook extends Table {
  public static Notebook getRootAsNotebook(ByteBuffer _bb) { return getRootAsNotebook(_bb, new Notebook()); }
  public static Notebook getRootAsNotebook(ByteBuffer _bb, Notebook obj) { _bb.order(ByteOrder.LITTLE_ENDIAN); return (obj.__init(_bb.getInt(_bb.position()) + _bb.position(), _bb)); }
  public Notebook __init(int _i, ByteBuffer _bb) { bb_pos = _i; bb = _bb; return this; }

  public String name() { int o = __offset(4); return o != 0 ? __string(o + bb_pos) : null; }
  public ByteBuffer nameAsByteBuffer() { return __vector_as_bytebuffer(4, 1); }
  public String notebookId() { int o = __offset(6); return o != 0 ? __string(o + bb_pos) : null; }
  public ByteBuffer notebookIdAsByteBuffer() { return __vector_as_bytebuffer(6, 1); }
  public boolean isDefault() { int o = __offset(8); return o != 0 ? 0!=bb.get(o + bb_pos) : false; }
  public String description() { int o = __offset(10); return o != 0 ? __string(o + bb_pos) : null; }
  public ByteBuffer descriptionAsByteBuffer() { return __vector_as_bytebuffer(10, 1); }
  public String location() { int o = __offset(12); return o != 0 ? __string(o + bb_pos) : null; }
  public ByteBuffer locationAsByteBuffer() { return __vector_as_bytebuffer(12, 1); }
  public float latitude() { int o = __offset(14); return o != 0 ? bb.getFloat(o + bb_pos) : 0; }
  public float longitude() { int o = __offset(16); return o != 0 ? bb.getFloat(o + bb_pos) : 0; }
  public String coverImageId() { int o = __offset(18); return o != 0 ? __string(o + bb_pos) : null; }
  public ByteBuffer coverImageIdAsByteBuffer() { return __vector_as_bytebuffer(18, 1); }
  public String createdTime() { int o = __offset(20); return o != 0 ? __string(o + bb_pos) : null; }
  public ByteBuffer createdTimeAsByteBuffer() { return __vector_as_bytebuffer(20, 1); }
  public String modifiedTime() { int o = __offset(22); return o != 0 ? __string(o + bb_pos) : null; }
  public ByteBuffer modifiedTimeAsByteBuffer() { return __vector_as_bytebuffer(22, 1); }
  public String lastAccessedTime() { int o = __offset(24); return o != 0 ? __string(o + bb_pos) : null; }
  public ByteBuffer lastAccessedTimeAsByteBuffer() { return __vector_as_bytebuffer(24, 1); }

  public static int createNotebook(FlatBufferBuilder builder,
      int name,
      int notebook_id,
      boolean is_default,
      int description,
      int location,
      float latitude,
      float longitude,
      int cover_image_id,
      int created_time,
      int modified_time,
      int last_accessed_time) {
    builder.startObject(11);
    Notebook.addLastAccessedTime(builder, last_accessed_time);
    Notebook.addModifiedTime(builder, modified_time);
    Notebook.addCreatedTime(builder, created_time);
    Notebook.addCoverImageId(builder, cover_image_id);
    Notebook.addLongitude(builder, longitude);
    Notebook.addLatitude(builder, latitude);
    Notebook.addLocation(builder, location);
    Notebook.addDescription(builder, description);
    Notebook.addNotebookId(builder, notebook_id);
    Notebook.addName(builder, name);
    Notebook.addIsDefault(builder, is_default);
    return Notebook.endNotebook(builder);
  }

  public static void startNotebook(FlatBufferBuilder builder) { builder.startObject(11); }
  public static void addName(FlatBufferBuilder builder, int nameOffset) { builder.addOffset(0, nameOffset, 0); }
  public static void addNotebookId(FlatBufferBuilder builder, int notebookIdOffset) { builder.addOffset(1, notebookIdOffset, 0); }
  public static void addIsDefault(FlatBufferBuilder builder, boolean isDefault) { builder.addBoolean(2, isDefault, false); }
  public static void addDescription(FlatBufferBuilder builder, int descriptionOffset) { builder.addOffset(3, descriptionOffset, 0); }
  public static void addLocation(FlatBufferBuilder builder, int locationOffset) { builder.addOffset(4, locationOffset, 0); }
  public static void addLatitude(FlatBufferBuilder builder, float latitude) { builder.addFloat(5, latitude, 0); }
  public static void addLongitude(FlatBufferBuilder builder, float longitude) { builder.addFloat(6, longitude, 0); }
  public static void addCoverImageId(FlatBufferBuilder builder, int coverImageIdOffset) { builder.addOffset(7, coverImageIdOffset, 0); }
  public static void addCreatedTime(FlatBufferBuilder builder, int createdTimeOffset) { builder.addOffset(8, createdTimeOffset, 0); }
  public static void addModifiedTime(FlatBufferBuilder builder, int modifiedTimeOffset) { builder.addOffset(9, modifiedTimeOffset, 0); }
  public static void addLastAccessedTime(FlatBufferBuilder builder, int lastAccessedTimeOffset) { builder.addOffset(10, lastAccessedTimeOffset, 0); }
  public static int endNotebook(FlatBufferBuilder builder) {
    int o = builder.endObject();
    return o;
  }
};

