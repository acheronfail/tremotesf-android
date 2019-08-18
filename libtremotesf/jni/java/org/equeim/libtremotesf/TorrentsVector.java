/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 4.0.1
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.equeim.libtremotesf;

public class TorrentsVector extends java.util.AbstractList<Torrent> implements java.util.RandomAccess {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected TorrentsVector(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(TorrentsVector obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  @SuppressWarnings("deprecation")
  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        libtremotesfJNI.delete_TorrentsVector(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public TorrentsVector(Torrent[] initialElements) {
    this();
    reserve(initialElements.length);

    for (Torrent element : initialElements) {
      add(element);
    }
  }

  public TorrentsVector(Iterable<Torrent> initialElements) {
    this();
    for (Torrent element : initialElements) {
      add(element);
    }
  }

  public Torrent get(int index) {
    return doGet(index);
  }

  public Torrent set(int index, Torrent e) {
    return doSet(index, e);
  }

  public boolean add(Torrent e) {
    modCount++;
    doAdd(e);
    return true;
  }

  public void add(int index, Torrent e) {
    modCount++;
    doAdd(index, e);
  }

  public Torrent remove(int index) {
    modCount++;
    return doRemove(index);
  }

  protected void removeRange(int fromIndex, int toIndex) {
    modCount++;
    doRemoveRange(fromIndex, toIndex);
  }

  public int size() {
    return doSize();
  }

  public TorrentsVector() {
    this(libtremotesfJNI.new_TorrentsVector__SWIG_0(), true);
  }

  public TorrentsVector(TorrentsVector other) {
    this(libtremotesfJNI.new_TorrentsVector__SWIG_1(TorrentsVector.getCPtr(other), other), true);
  }

  public long capacity() {
    return libtremotesfJNI.TorrentsVector_capacity(swigCPtr, this);
  }

  public void reserve(long n) {
    libtremotesfJNI.TorrentsVector_reserve(swigCPtr, this, n);
  }

  public boolean isEmpty() {
    return libtremotesfJNI.TorrentsVector_isEmpty(swigCPtr, this);
  }

  public void clear() {
    libtremotesfJNI.TorrentsVector_clear(swigCPtr, this);
  }

  public TorrentsVector(int count, Torrent value) {
    this(libtremotesfJNI.new_TorrentsVector__SWIG_2(count, Torrent.getCPtr(value), value), true);
  }

  private int doSize() {
    return libtremotesfJNI.TorrentsVector_doSize(swigCPtr, this);
  }

  private void doAdd(Torrent x) {
    libtremotesfJNI.TorrentsVector_doAdd__SWIG_0(swigCPtr, this, Torrent.getCPtr(x), x);
  }

  private void doAdd(int index, Torrent x) {
    libtremotesfJNI.TorrentsVector_doAdd__SWIG_1(swigCPtr, this, index, Torrent.getCPtr(x), x);
  }

  private Torrent doRemove(int index) {
    long cPtr = libtremotesfJNI.TorrentsVector_doRemove(swigCPtr, this, index);
    return (cPtr == 0) ? null : new Torrent(cPtr, true);
  }

  private Torrent doGet(int index) {
    long cPtr = libtremotesfJNI.TorrentsVector_doGet(swigCPtr, this, index);
    return (cPtr == 0) ? null : new Torrent(cPtr, true);
  }

  private Torrent doSet(int index, Torrent val) {
    long cPtr = libtremotesfJNI.TorrentsVector_doSet(swigCPtr, this, index, Torrent.getCPtr(val), val);
    return (cPtr == 0) ? null : new Torrent(cPtr, true);
  }

  private void doRemoveRange(int fromIndex, int toIndex) {
    libtremotesfJNI.TorrentsVector_doRemoveRange(swigCPtr, this, fromIndex, toIndex);
  }

}
