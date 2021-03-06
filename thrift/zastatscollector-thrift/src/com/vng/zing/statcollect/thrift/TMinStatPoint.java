/**
 * Autogenerated by Thrift Compiler (0.9.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.vng.zing.statcollect.thrift;

import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;

import org.apache.thrift.scheme.TupleScheme;
import org.apache.thrift.protocol.TTupleProtocol;
import org.apache.thrift.protocol.TProtocolException;
import org.apache.thrift.EncodingUtils;
import org.apache.thrift.TException;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.Set;
import java.util.HashSet;
import java.util.EnumSet;
import java.util.Collections;
import java.util.BitSet;
import java.nio.ByteBuffer;
import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TMinStatPoint implements org.apache.thrift.TBase<TMinStatPoint, TMinStatPoint._Fields>, java.io.Serializable, Cloneable {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("TMinStatPoint");

  private static final org.apache.thrift.protocol.TField TOTAL_REQ_FIELD_DESC = new org.apache.thrift.protocol.TField("totalReq", org.apache.thrift.protocol.TType.I32, (short)1);
  private static final org.apache.thrift.protocol.TField TOTAL_TIME_PROC_FIELD_DESC = new org.apache.thrift.protocol.TField("totalTimeProc", org.apache.thrift.protocol.TType.I64, (short)2);
  private static final org.apache.thrift.protocol.TField TIMESTAMP_FIELD_DESC = new org.apache.thrift.protocol.TField("timestamp", org.apache.thrift.protocol.TType.I64, (short)3);
  private static final org.apache.thrift.protocol.TField PEAK_TIME_PROC_FIELD_DESC = new org.apache.thrift.protocol.TField("peakTimeProc", org.apache.thrift.protocol.TType.STRUCT, (short)4);
  private static final org.apache.thrift.protocol.TField PEAK_PENDING_REQ_FIELD_DESC = new org.apache.thrift.protocol.TField("peakPendingReq", org.apache.thrift.protocol.TType.STRUCT, (short)5);
  private static final org.apache.thrift.protocol.TField PEAK_REQ_RATE_SECOND_FIELD_DESC = new org.apache.thrift.protocol.TField("peakReqRateSecond", org.apache.thrift.protocol.TType.STRUCT, (short)6);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new TMinStatPointStandardSchemeFactory());
    schemes.put(TupleScheme.class, new TMinStatPointTupleSchemeFactory());
  }

  public int totalReq; // required
  public long totalTimeProc; // required
  public long timestamp; // required
  public TPeakInfo peakTimeProc; // required
  public TPeakInfo peakPendingReq; // required
  public TPeakInfo peakReqRateSecond; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    TOTAL_REQ((short)1, "totalReq"),
    TOTAL_TIME_PROC((short)2, "totalTimeProc"),
    TIMESTAMP((short)3, "timestamp"),
    PEAK_TIME_PROC((short)4, "peakTimeProc"),
    PEAK_PENDING_REQ((short)5, "peakPendingReq"),
    PEAK_REQ_RATE_SECOND((short)6, "peakReqRateSecond");

    private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

    static {
      for (_Fields field : EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // TOTAL_REQ
          return TOTAL_REQ;
        case 2: // TOTAL_TIME_PROC
          return TOTAL_TIME_PROC;
        case 3: // TIMESTAMP
          return TIMESTAMP;
        case 4: // PEAK_TIME_PROC
          return PEAK_TIME_PROC;
        case 5: // PEAK_PENDING_REQ
          return PEAK_PENDING_REQ;
        case 6: // PEAK_REQ_RATE_SECOND
          return PEAK_REQ_RATE_SECOND;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final String _fieldName;

    _Fields(short thriftId, String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  private static final int __TOTALREQ_ISSET_ID = 0;
  private static final int __TOTALTIMEPROC_ISSET_ID = 1;
  private static final int __TIMESTAMP_ISSET_ID = 2;
  private byte __isset_bitfield = 0;
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.TOTAL_REQ, new org.apache.thrift.meta_data.FieldMetaData("totalReq", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.TOTAL_TIME_PROC, new org.apache.thrift.meta_data.FieldMetaData("totalTimeProc", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)));
    tmpMap.put(_Fields.TIMESTAMP, new org.apache.thrift.meta_data.FieldMetaData("timestamp", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)));
    tmpMap.put(_Fields.PEAK_TIME_PROC, new org.apache.thrift.meta_data.FieldMetaData("peakTimeProc", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, TPeakInfo.class)));
    tmpMap.put(_Fields.PEAK_PENDING_REQ, new org.apache.thrift.meta_data.FieldMetaData("peakPendingReq", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, TPeakInfo.class)));
    tmpMap.put(_Fields.PEAK_REQ_RATE_SECOND, new org.apache.thrift.meta_data.FieldMetaData("peakReqRateSecond", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, TPeakInfo.class)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(TMinStatPoint.class, metaDataMap);
  }

  public TMinStatPoint() {
  }

  public TMinStatPoint(
    int totalReq,
    long totalTimeProc,
    long timestamp,
    TPeakInfo peakTimeProc,
    TPeakInfo peakPendingReq,
    TPeakInfo peakReqRateSecond)
  {
    this();
    this.totalReq = totalReq;
    setTotalReqIsSet(true);
    this.totalTimeProc = totalTimeProc;
    setTotalTimeProcIsSet(true);
    this.timestamp = timestamp;
    setTimestampIsSet(true);
    this.peakTimeProc = peakTimeProc;
    this.peakPendingReq = peakPendingReq;
    this.peakReqRateSecond = peakReqRateSecond;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public TMinStatPoint(TMinStatPoint other) {
    __isset_bitfield = other.__isset_bitfield;
    this.totalReq = other.totalReq;
    this.totalTimeProc = other.totalTimeProc;
    this.timestamp = other.timestamp;
    if (other.isSetPeakTimeProc()) {
      this.peakTimeProc = new TPeakInfo(other.peakTimeProc);
    }
    if (other.isSetPeakPendingReq()) {
      this.peakPendingReq = new TPeakInfo(other.peakPendingReq);
    }
    if (other.isSetPeakReqRateSecond()) {
      this.peakReqRateSecond = new TPeakInfo(other.peakReqRateSecond);
    }
  }

  public TMinStatPoint deepCopy() {
    return new TMinStatPoint(this);
  }

  @Override
  public void clear() {
    setTotalReqIsSet(false);
    this.totalReq = 0;
    setTotalTimeProcIsSet(false);
    this.totalTimeProc = 0;
    setTimestampIsSet(false);
    this.timestamp = 0;
    this.peakTimeProc = null;
    this.peakPendingReq = null;
    this.peakReqRateSecond = null;
  }

  public int getTotalReq() {
    return this.totalReq;
  }

  public TMinStatPoint setTotalReq(int totalReq) {
    this.totalReq = totalReq;
    setTotalReqIsSet(true);
    return this;
  }

  public void unsetTotalReq() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __TOTALREQ_ISSET_ID);
  }

  /** Returns true if field totalReq is set (has been assigned a value) and false otherwise */
  public boolean isSetTotalReq() {
    return EncodingUtils.testBit(__isset_bitfield, __TOTALREQ_ISSET_ID);
  }

  public void setTotalReqIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __TOTALREQ_ISSET_ID, value);
  }

  public long getTotalTimeProc() {
    return this.totalTimeProc;
  }

  public TMinStatPoint setTotalTimeProc(long totalTimeProc) {
    this.totalTimeProc = totalTimeProc;
    setTotalTimeProcIsSet(true);
    return this;
  }

  public void unsetTotalTimeProc() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __TOTALTIMEPROC_ISSET_ID);
  }

  /** Returns true if field totalTimeProc is set (has been assigned a value) and false otherwise */
  public boolean isSetTotalTimeProc() {
    return EncodingUtils.testBit(__isset_bitfield, __TOTALTIMEPROC_ISSET_ID);
  }

  public void setTotalTimeProcIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __TOTALTIMEPROC_ISSET_ID, value);
  }

  public long getTimestamp() {
    return this.timestamp;
  }

  public TMinStatPoint setTimestamp(long timestamp) {
    this.timestamp = timestamp;
    setTimestampIsSet(true);
    return this;
  }

  public void unsetTimestamp() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __TIMESTAMP_ISSET_ID);
  }

  /** Returns true if field timestamp is set (has been assigned a value) and false otherwise */
  public boolean isSetTimestamp() {
    return EncodingUtils.testBit(__isset_bitfield, __TIMESTAMP_ISSET_ID);
  }

  public void setTimestampIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __TIMESTAMP_ISSET_ID, value);
  }

  public TPeakInfo getPeakTimeProc() {
    return this.peakTimeProc;
  }

  public TMinStatPoint setPeakTimeProc(TPeakInfo peakTimeProc) {
    this.peakTimeProc = peakTimeProc;
    return this;
  }

  public void unsetPeakTimeProc() {
    this.peakTimeProc = null;
  }

  /** Returns true if field peakTimeProc is set (has been assigned a value) and false otherwise */
  public boolean isSetPeakTimeProc() {
    return this.peakTimeProc != null;
  }

  public void setPeakTimeProcIsSet(boolean value) {
    if (!value) {
      this.peakTimeProc = null;
    }
  }

  public TPeakInfo getPeakPendingReq() {
    return this.peakPendingReq;
  }

  public TMinStatPoint setPeakPendingReq(TPeakInfo peakPendingReq) {
    this.peakPendingReq = peakPendingReq;
    return this;
  }

  public void unsetPeakPendingReq() {
    this.peakPendingReq = null;
  }

  /** Returns true if field peakPendingReq is set (has been assigned a value) and false otherwise */
  public boolean isSetPeakPendingReq() {
    return this.peakPendingReq != null;
  }

  public void setPeakPendingReqIsSet(boolean value) {
    if (!value) {
      this.peakPendingReq = null;
    }
  }

  public TPeakInfo getPeakReqRateSecond() {
    return this.peakReqRateSecond;
  }

  public TMinStatPoint setPeakReqRateSecond(TPeakInfo peakReqRateSecond) {
    this.peakReqRateSecond = peakReqRateSecond;
    return this;
  }

  public void unsetPeakReqRateSecond() {
    this.peakReqRateSecond = null;
  }

  /** Returns true if field peakReqRateSecond is set (has been assigned a value) and false otherwise */
  public boolean isSetPeakReqRateSecond() {
    return this.peakReqRateSecond != null;
  }

  public void setPeakReqRateSecondIsSet(boolean value) {
    if (!value) {
      this.peakReqRateSecond = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case TOTAL_REQ:
      if (value == null) {
        unsetTotalReq();
      } else {
        setTotalReq((Integer)value);
      }
      break;

    case TOTAL_TIME_PROC:
      if (value == null) {
        unsetTotalTimeProc();
      } else {
        setTotalTimeProc((Long)value);
      }
      break;

    case TIMESTAMP:
      if (value == null) {
        unsetTimestamp();
      } else {
        setTimestamp((Long)value);
      }
      break;

    case PEAK_TIME_PROC:
      if (value == null) {
        unsetPeakTimeProc();
      } else {
        setPeakTimeProc((TPeakInfo)value);
      }
      break;

    case PEAK_PENDING_REQ:
      if (value == null) {
        unsetPeakPendingReq();
      } else {
        setPeakPendingReq((TPeakInfo)value);
      }
      break;

    case PEAK_REQ_RATE_SECOND:
      if (value == null) {
        unsetPeakReqRateSecond();
      } else {
        setPeakReqRateSecond((TPeakInfo)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case TOTAL_REQ:
      return Integer.valueOf(getTotalReq());

    case TOTAL_TIME_PROC:
      return Long.valueOf(getTotalTimeProc());

    case TIMESTAMP:
      return Long.valueOf(getTimestamp());

    case PEAK_TIME_PROC:
      return getPeakTimeProc();

    case PEAK_PENDING_REQ:
      return getPeakPendingReq();

    case PEAK_REQ_RATE_SECOND:
      return getPeakReqRateSecond();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case TOTAL_REQ:
      return isSetTotalReq();
    case TOTAL_TIME_PROC:
      return isSetTotalTimeProc();
    case TIMESTAMP:
      return isSetTimestamp();
    case PEAK_TIME_PROC:
      return isSetPeakTimeProc();
    case PEAK_PENDING_REQ:
      return isSetPeakPendingReq();
    case PEAK_REQ_RATE_SECOND:
      return isSetPeakReqRateSecond();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof TMinStatPoint)
      return this.equals((TMinStatPoint)that);
    return false;
  }

  public boolean equals(TMinStatPoint that) {
    if (that == null)
      return false;

    boolean this_present_totalReq = true;
    boolean that_present_totalReq = true;
    if (this_present_totalReq || that_present_totalReq) {
      if (!(this_present_totalReq && that_present_totalReq))
        return false;
      if (this.totalReq != that.totalReq)
        return false;
    }

    boolean this_present_totalTimeProc = true;
    boolean that_present_totalTimeProc = true;
    if (this_present_totalTimeProc || that_present_totalTimeProc) {
      if (!(this_present_totalTimeProc && that_present_totalTimeProc))
        return false;
      if (this.totalTimeProc != that.totalTimeProc)
        return false;
    }

    boolean this_present_timestamp = true;
    boolean that_present_timestamp = true;
    if (this_present_timestamp || that_present_timestamp) {
      if (!(this_present_timestamp && that_present_timestamp))
        return false;
      if (this.timestamp != that.timestamp)
        return false;
    }

    boolean this_present_peakTimeProc = true && this.isSetPeakTimeProc();
    boolean that_present_peakTimeProc = true && that.isSetPeakTimeProc();
    if (this_present_peakTimeProc || that_present_peakTimeProc) {
      if (!(this_present_peakTimeProc && that_present_peakTimeProc))
        return false;
      if (!this.peakTimeProc.equals(that.peakTimeProc))
        return false;
    }

    boolean this_present_peakPendingReq = true && this.isSetPeakPendingReq();
    boolean that_present_peakPendingReq = true && that.isSetPeakPendingReq();
    if (this_present_peakPendingReq || that_present_peakPendingReq) {
      if (!(this_present_peakPendingReq && that_present_peakPendingReq))
        return false;
      if (!this.peakPendingReq.equals(that.peakPendingReq))
        return false;
    }

    boolean this_present_peakReqRateSecond = true && this.isSetPeakReqRateSecond();
    boolean that_present_peakReqRateSecond = true && that.isSetPeakReqRateSecond();
    if (this_present_peakReqRateSecond || that_present_peakReqRateSecond) {
      if (!(this_present_peakReqRateSecond && that_present_peakReqRateSecond))
        return false;
      if (!this.peakReqRateSecond.equals(that.peakReqRateSecond))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  public int compareTo(TMinStatPoint other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;
    TMinStatPoint typedOther = (TMinStatPoint)other;

    lastComparison = Boolean.valueOf(isSetTotalReq()).compareTo(typedOther.isSetTotalReq());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetTotalReq()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.totalReq, typedOther.totalReq);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetTotalTimeProc()).compareTo(typedOther.isSetTotalTimeProc());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetTotalTimeProc()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.totalTimeProc, typedOther.totalTimeProc);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetTimestamp()).compareTo(typedOther.isSetTimestamp());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetTimestamp()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.timestamp, typedOther.timestamp);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetPeakTimeProc()).compareTo(typedOther.isSetPeakTimeProc());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetPeakTimeProc()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.peakTimeProc, typedOther.peakTimeProc);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetPeakPendingReq()).compareTo(typedOther.isSetPeakPendingReq());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetPeakPendingReq()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.peakPendingReq, typedOther.peakPendingReq);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetPeakReqRateSecond()).compareTo(typedOther.isSetPeakReqRateSecond());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetPeakReqRateSecond()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.peakReqRateSecond, typedOther.peakReqRateSecond);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("TMinStatPoint(");
    boolean first = true;

    sb.append("totalReq:");
    sb.append(this.totalReq);
    first = false;
    if (!first) sb.append(", ");
    sb.append("totalTimeProc:");
    sb.append(this.totalTimeProc);
    first = false;
    if (!first) sb.append(", ");
    sb.append("timestamp:");
    sb.append(this.timestamp);
    first = false;
    if (!first) sb.append(", ");
    sb.append("peakTimeProc:");
    if (this.peakTimeProc == null) {
      sb.append("null");
    } else {
      sb.append(this.peakTimeProc);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("peakPendingReq:");
    if (this.peakPendingReq == null) {
      sb.append("null");
    } else {
      sb.append(this.peakPendingReq);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("peakReqRateSecond:");
    if (this.peakReqRateSecond == null) {
      sb.append("null");
    } else {
      sb.append(this.peakReqRateSecond);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // alas, we cannot check 'totalReq' because it's a primitive and you chose the non-beans generator.
    // alas, we cannot check 'totalTimeProc' because it's a primitive and you chose the non-beans generator.
    // alas, we cannot check 'timestamp' because it's a primitive and you chose the non-beans generator.
    if (peakTimeProc == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'peakTimeProc' was not present! Struct: " + toString());
    }
    if (peakPendingReq == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'peakPendingReq' was not present! Struct: " + toString());
    }
    if (peakReqRateSecond == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'peakReqRateSecond' was not present! Struct: " + toString());
    }
    // check for sub-struct validity
    if (peakTimeProc != null) {
      peakTimeProc.validate();
    }
    if (peakPendingReq != null) {
      peakPendingReq.validate();
    }
    if (peakReqRateSecond != null) {
      peakReqRateSecond.validate();
    }
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
    try {
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bitfield = 0;
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class TMinStatPointStandardSchemeFactory implements SchemeFactory {
    public TMinStatPointStandardScheme getScheme() {
      return new TMinStatPointStandardScheme();
    }
  }

  private static class TMinStatPointStandardScheme extends StandardScheme<TMinStatPoint> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, TMinStatPoint struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // TOTAL_REQ
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.totalReq = iprot.readI32();
              struct.setTotalReqIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // TOTAL_TIME_PROC
            if (schemeField.type == org.apache.thrift.protocol.TType.I64) {
              struct.totalTimeProc = iprot.readI64();
              struct.setTotalTimeProcIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // TIMESTAMP
            if (schemeField.type == org.apache.thrift.protocol.TType.I64) {
              struct.timestamp = iprot.readI64();
              struct.setTimestampIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // PEAK_TIME_PROC
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.peakTimeProc = new TPeakInfo();
              struct.peakTimeProc.read(iprot);
              struct.setPeakTimeProcIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 5: // PEAK_PENDING_REQ
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.peakPendingReq = new TPeakInfo();
              struct.peakPendingReq.read(iprot);
              struct.setPeakPendingReqIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 6: // PEAK_REQ_RATE_SECOND
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.peakReqRateSecond = new TPeakInfo();
              struct.peakReqRateSecond.read(iprot);
              struct.setPeakReqRateSecondIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      if (!struct.isSetTotalReq()) {
        throw new org.apache.thrift.protocol.TProtocolException("Required field 'totalReq' was not found in serialized data! Struct: " + toString());
      }
      if (!struct.isSetTotalTimeProc()) {
        throw new org.apache.thrift.protocol.TProtocolException("Required field 'totalTimeProc' was not found in serialized data! Struct: " + toString());
      }
      if (!struct.isSetTimestamp()) {
        throw new org.apache.thrift.protocol.TProtocolException("Required field 'timestamp' was not found in serialized data! Struct: " + toString());
      }
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, TMinStatPoint struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      oprot.writeFieldBegin(TOTAL_REQ_FIELD_DESC);
      oprot.writeI32(struct.totalReq);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(TOTAL_TIME_PROC_FIELD_DESC);
      oprot.writeI64(struct.totalTimeProc);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(TIMESTAMP_FIELD_DESC);
      oprot.writeI64(struct.timestamp);
      oprot.writeFieldEnd();
      if (struct.peakTimeProc != null) {
        oprot.writeFieldBegin(PEAK_TIME_PROC_FIELD_DESC);
        struct.peakTimeProc.write(oprot);
        oprot.writeFieldEnd();
      }
      if (struct.peakPendingReq != null) {
        oprot.writeFieldBegin(PEAK_PENDING_REQ_FIELD_DESC);
        struct.peakPendingReq.write(oprot);
        oprot.writeFieldEnd();
      }
      if (struct.peakReqRateSecond != null) {
        oprot.writeFieldBegin(PEAK_REQ_RATE_SECOND_FIELD_DESC);
        struct.peakReqRateSecond.write(oprot);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class TMinStatPointTupleSchemeFactory implements SchemeFactory {
    public TMinStatPointTupleScheme getScheme() {
      return new TMinStatPointTupleScheme();
    }
  }

  private static class TMinStatPointTupleScheme extends TupleScheme<TMinStatPoint> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, TMinStatPoint struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      oprot.writeI32(struct.totalReq);
      oprot.writeI64(struct.totalTimeProc);
      oprot.writeI64(struct.timestamp);
      struct.peakTimeProc.write(oprot);
      struct.peakPendingReq.write(oprot);
      struct.peakReqRateSecond.write(oprot);
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, TMinStatPoint struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      struct.totalReq = iprot.readI32();
      struct.setTotalReqIsSet(true);
      struct.totalTimeProc = iprot.readI64();
      struct.setTotalTimeProcIsSet(true);
      struct.timestamp = iprot.readI64();
      struct.setTimestampIsSet(true);
      struct.peakTimeProc = new TPeakInfo();
      struct.peakTimeProc.read(iprot);
      struct.setPeakTimeProcIsSet(true);
      struct.peakPendingReq = new TPeakInfo();
      struct.peakPendingReq.read(iprot);
      struct.setPeakPendingReqIsSet(true);
      struct.peakReqRateSecond = new TPeakInfo();
      struct.peakReqRateSecond.read(iprot);
      struct.setPeakReqRateSecondIsSet(true);
    }
  }

}

