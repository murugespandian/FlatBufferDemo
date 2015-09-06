// automatically generated, do not modify

package com.example.flatbufferdemo;

import java.nio.*;
import java.lang.*;
import java.util.*;
import com.google.flatbuffers.*;

public final class PageContext extends Table {
  public static PageContext getRootAsPageContext(ByteBuffer _bb) { return getRootAsPageContext(_bb, new PageContext()); }
  public static PageContext getRootAsPageContext(ByteBuffer _bb, PageContext obj) { _bb.order(ByteOrder.LITTLE_ENDIAN); return (obj.__init(_bb.getInt(_bb.position()) + _bb.position(), _bb)); }
  public PageContext __init(int _i, ByteBuffer _bb) { bb_pos = _i; bb = _bb; return this; }

  public String viewType() { int o = __offset(4); return o != 0 ? __string(o + bb_pos) : null; }
  public ByteBuffer viewTypeAsByteBuffer() { return __vector_as_bytebuffer(4, 1); }
  public String sortType() { int o = __offset(6); return o != 0 ? __string(o + bb_pos) : null; }
  public ByteBuffer sortTypeAsByteBuffer() { return __vector_as_bytebuffer(6, 1); }
  public String sortOrder() { int o = __offset(8); return o != 0 ? __string(o + bb_pos) : null; }
  public ByteBuffer sortOrderAsByteBuffer() { return __vector_as_bytebuffer(8, 1); }
  public long pageLimit() { int o = __offset(10); return o != 0 ? bb.getLong(o + bb_pos) : 0; }

  public static int createPageContext(FlatBufferBuilder builder,
      int view_type,
      int sort_type,
      int sort_order,
      long page_limit) {
    builder.startObject(4);
    PageContext.addPageLimit(builder, page_limit);
    PageContext.addSortOrder(builder, sort_order);
    PageContext.addSortType(builder, sort_type);
    PageContext.addViewType(builder, view_type);
    return PageContext.endPageContext(builder);
  }

  public static void startPageContext(FlatBufferBuilder builder) { builder.startObject(4); }
  public static void addViewType(FlatBufferBuilder builder, int viewTypeOffset) { builder.addOffset(0, viewTypeOffset, 0); }
  public static void addSortType(FlatBufferBuilder builder, int sortTypeOffset) { builder.addOffset(1, sortTypeOffset, 0); }
  public static void addSortOrder(FlatBufferBuilder builder, int sortOrderOffset) { builder.addOffset(2, sortOrderOffset, 0); }
  public static void addPageLimit(FlatBufferBuilder builder, long pageLimit) { builder.addLong(3, pageLimit, 0); }
  public static int endPageContext(FlatBufferBuilder builder) {
    int o = builder.endObject();
    return o;
  }
};

