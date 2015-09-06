// automatically generated, do not modify

package com.example.flatbufferdemo;

import java.nio.*;
import java.lang.*;
import java.util.*;
import com.google.flatbuffers.*;

public final class NotebookList extends Table {
  public static NotebookList getRootAsNotebookList(ByteBuffer _bb) { return getRootAsNotebookList(_bb, new NotebookList()); }
  public static NotebookList getRootAsNotebookList(ByteBuffer _bb, NotebookList obj) { _bb.order(ByteOrder.LITTLE_ENDIAN); return (obj.__init(_bb.getInt(_bb.position()) + _bb.position(), _bb)); }
  public NotebookList __init(int _i, ByteBuffer _bb) { bb_pos = _i; bb = _bb; return this; }

  public long code() { int o = __offset(4); return o != 0 ? bb.getLong(o + bb_pos) : 0; }
  public String status() { int o = __offset(6); return o != 0 ? __string(o + bb_pos) : null; }
  public ByteBuffer statusAsByteBuffer() { return __vector_as_bytebuffer(6, 1); }
  public String message() { int o = __offset(8); return o != 0 ? __string(o + bb_pos) : null; }
  public ByteBuffer messageAsByteBuffer() { return __vector_as_bytebuffer(8, 1); }
  public Notebook notebooks(int j) { return notebooks(new Notebook(), j); }
  public Notebook notebooks(Notebook obj, int j) { int o = __offset(10); return o != 0 ? obj.__init(__indirect(__vector(o) + j * 4), bb) : null; }
  public int notebooksLength() { int o = __offset(10); return o != 0 ? __vector_len(o) : 0; }
  public PageContext pageContext() { return pageContext(new PageContext()); }
  public PageContext pageContext(PageContext obj) { int o = __offset(12); return o != 0 ? obj.__init(__indirect(o + bb_pos), bb) : null; }

  public static int createNotebookList(FlatBufferBuilder builder,
      long code,
      int status,
      int message,
      int notebooks,
      int page_context) {
    builder.startObject(5);
    NotebookList.addCode(builder, code);
    NotebookList.addPageContext(builder, page_context);
    NotebookList.addNotebooks(builder, notebooks);
    NotebookList.addMessage(builder, message);
    NotebookList.addStatus(builder, status);
    return NotebookList.endNotebookList(builder);
  }

  public static void startNotebookList(FlatBufferBuilder builder) { builder.startObject(5); }
  public static void addCode(FlatBufferBuilder builder, long code) { builder.addLong(0, code, 0); }
  public static void addStatus(FlatBufferBuilder builder, int statusOffset) { builder.addOffset(1, statusOffset, 0); }
  public static void addMessage(FlatBufferBuilder builder, int messageOffset) { builder.addOffset(2, messageOffset, 0); }
  public static void addNotebooks(FlatBufferBuilder builder, int notebooksOffset) { builder.addOffset(3, notebooksOffset, 0); }
  public static int createNotebooksVector(FlatBufferBuilder builder, int[] data) { builder.startVector(4, data.length, 4); for (int i = data.length - 1; i >= 0; i--) builder.addOffset(data[i]); return builder.endVector(); }
  public static void startNotebooksVector(FlatBufferBuilder builder, int numElems) { builder.startVector(4, numElems, 4); }
  public static void addPageContext(FlatBufferBuilder builder, int pageContextOffset) { builder.addOffset(4, pageContextOffset, 0); }
  public static int endNotebookList(FlatBufferBuilder builder) {
    int o = builder.endObject();
    return o;
  }
  public static void finishNotebookListBuffer(FlatBufferBuilder builder, int offset) { builder.finish(offset); }
};

