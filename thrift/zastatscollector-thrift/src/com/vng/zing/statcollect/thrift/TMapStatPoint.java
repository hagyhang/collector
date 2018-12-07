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

public class TMapStatPoint implements org.apache.thrift.TBase<TMapStatPoint, TMapStatPoint._Fields>, java.io.Serializable, Cloneable {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("TMapStatPoint");

  private static final org.apache.thrift.protocol.TField SECOND_MAP_FIELD_DESC = new org.apache.thrift.protocol.TField("secondMap", org.apache.thrift.protocol.TType.MAP, (short)1);
  private static final org.apache.thrift.protocol.TField MINUTE_MAP_FIELD_DESC = new org.apache.thrift.protocol.TField("minuteMap", org.apache.thrift.protocol.TType.MAP, (short)2);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new TMapStatPointStandardSchemeFactory());
    schemes.put(TupleScheme.class, new TMapStatPointTupleSchemeFactory());
  }

  public Map<String,TSecStatPoint> secondMap; // optional
  public Map<String,TMinStatPoint> minuteMap; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    SECOND_MAP((short)1, "secondMap"),
    MINUTE_MAP((short)2, "minuteMap");

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
        case 1: // SECOND_MAP
          return SECOND_MAP;
        case 2: // MINUTE_MAP
          return MINUTE_MAP;
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
  private _Fields optionals[] = {_Fields.SECOND_MAP,_Fields.MINUTE_MAP};
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.SECOND_MAP, new org.apache.thrift.meta_data.FieldMetaData("secondMap", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.MapMetaData(org.apache.thrift.protocol.TType.MAP, 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING), 
            new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, TSecStatPoint.class))));
    tmpMap.put(_Fields.MINUTE_MAP, new org.apache.thrift.meta_data.FieldMetaData("minuteMap", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.MapMetaData(org.apache.thrift.protocol.TType.MAP, 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING), 
            new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, TMinStatPoint.class))));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(TMapStatPoint.class, metaDataMap);
  }

  public TMapStatPoint() {
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public TMapStatPoint(TMapStatPoint other) {
    if (other.isSetSecondMap()) {
      Map<String,TSecStatPoint> __this__secondMap = new HashMap<String,TSecStatPoint>();
      for (Map.Entry<String, TSecStatPoint> other_element : other.secondMap.entrySet()) {

        String other_element_key = other_element.getKey();
        TSecStatPoint other_element_value = other_element.getValue();

        String __this__secondMap_copy_key = other_element_key;

        TSecStatPoint __this__secondMap_copy_value = new TSecStatPoint(other_element_value);

        __this__secondMap.put(__this__secondMap_copy_key, __this__secondMap_copy_value);
      }
      this.secondMap = __this__secondMap;
    }
    if (other.isSetMinuteMap()) {
      Map<String,TMinStatPoint> __this__minuteMap = new HashMap<String,TMinStatPoint>();
      for (Map.Entry<String, TMinStatPoint> other_element : other.minuteMap.entrySet()) {

        String other_element_key = other_element.getKey();
        TMinStatPoint other_element_value = other_element.getValue();

        String __this__minuteMap_copy_key = other_element_key;

        TMinStatPoint __this__minuteMap_copy_value = new TMinStatPoint(other_element_value);

        __this__minuteMap.put(__this__minuteMap_copy_key, __this__minuteMap_copy_value);
      }
      this.minuteMap = __this__minuteMap;
    }
  }

  public TMapStatPoint deepCopy() {
    return new TMapStatPoint(this);
  }

  @Override
  public void clear() {
    this.secondMap = null;
    this.minuteMap = null;
  }

  public int getSecondMapSize() {
    return (this.secondMap == null) ? 0 : this.secondMap.size();
  }

  public void putToSecondMap(String key, TSecStatPoint val) {
    if (this.secondMap == null) {
      this.secondMap = new HashMap<String,TSecStatPoint>();
    }
    this.secondMap.put(key, val);
  }

  public Map<String,TSecStatPoint> getSecondMap() {
    return this.secondMap;
  }

  public TMapStatPoint setSecondMap(Map<String,TSecStatPoint> secondMap) {
    this.secondMap = secondMap;
    return this;
  }

  public void unsetSecondMap() {
    this.secondMap = null;
  }

  /** Returns true if field secondMap is set (has been assigned a value) and false otherwise */
  public boolean isSetSecondMap() {
    return this.secondMap != null;
  }

  public void setSecondMapIsSet(boolean value) {
    if (!value) {
      this.secondMap = null;
    }
  }

  public int getMinuteMapSize() {
    return (this.minuteMap == null) ? 0 : this.minuteMap.size();
  }

  public void putToMinuteMap(String key, TMinStatPoint val) {
    if (this.minuteMap == null) {
      this.minuteMap = new HashMap<String,TMinStatPoint>();
    }
    this.minuteMap.put(key, val);
  }

  public Map<String,TMinStatPoint> getMinuteMap() {
    return this.minuteMap;
  }

  public TMapStatPoint setMinuteMap(Map<String,TMinStatPoint> minuteMap) {
    this.minuteMap = minuteMap;
    return this;
  }

  public void unsetMinuteMap() {
    this.minuteMap = null;
  }

  /** Returns true if field minuteMap is set (has been assigned a value) and false otherwise */
  public boolean isSetMinuteMap() {
    return this.minuteMap != null;
  }

  public void setMinuteMapIsSet(boolean value) {
    if (!value) {
      this.minuteMap = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case SECOND_MAP:
      if (value == null) {
        unsetSecondMap();
      } else {
        setSecondMap((Map<String,TSecStatPoint>)value);
      }
      break;

    case MINUTE_MAP:
      if (value == null) {
        unsetMinuteMap();
      } else {
        setMinuteMap((Map<String,TMinStatPoint>)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case SECOND_MAP:
      return getSecondMap();

    case MINUTE_MAP:
      return getMinuteMap();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case SECOND_MAP:
      return isSetSecondMap();
    case MINUTE_MAP:
      return isSetMinuteMap();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof TMapStatPoint)
      return this.equals((TMapStatPoint)that);
    return false;
  }

  public boolean equals(TMapStatPoint that) {
    if (that == null)
      return false;

    boolean this_present_secondMap = true && this.isSetSecondMap();
    boolean that_present_secondMap = true && that.isSetSecondMap();
    if (this_present_secondMap || that_present_secondMap) {
      if (!(this_present_secondMap && that_present_secondMap))
        return false;
      if (!this.secondMap.equals(that.secondMap))
        return false;
    }

    boolean this_present_minuteMap = true && this.isSetMinuteMap();
    boolean that_present_minuteMap = true && that.isSetMinuteMap();
    if (this_present_minuteMap || that_present_minuteMap) {
      if (!(this_present_minuteMap && that_present_minuteMap))
        return false;
      if (!this.minuteMap.equals(that.minuteMap))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  public int compareTo(TMapStatPoint other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;
    TMapStatPoint typedOther = (TMapStatPoint)other;

    lastComparison = Boolean.valueOf(isSetSecondMap()).compareTo(typedOther.isSetSecondMap());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetSecondMap()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.secondMap, typedOther.secondMap);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetMinuteMap()).compareTo(typedOther.isSetMinuteMap());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetMinuteMap()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.minuteMap, typedOther.minuteMap);
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
    StringBuilder sb = new StringBuilder("TMapStatPoint(");
    boolean first = true;

    if (isSetSecondMap()) {
      sb.append("secondMap:");
      if (this.secondMap == null) {
        sb.append("null");
      } else {
        sb.append(this.secondMap);
      }
      first = false;
    }
    if (isSetMinuteMap()) {
      if (!first) sb.append(", ");
      sb.append("minuteMap:");
      if (this.minuteMap == null) {
        sb.append("null");
      } else {
        sb.append(this.minuteMap);
      }
      first = false;
    }
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // check for sub-struct validity
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
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class TMapStatPointStandardSchemeFactory implements SchemeFactory {
    public TMapStatPointStandardScheme getScheme() {
      return new TMapStatPointStandardScheme();
    }
  }

  private static class TMapStatPointStandardScheme extends StandardScheme<TMapStatPoint> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, TMapStatPoint struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // SECOND_MAP
            if (schemeField.type == org.apache.thrift.protocol.TType.MAP) {
              {
                org.apache.thrift.protocol.TMap _map0 = iprot.readMapBegin();
                struct.secondMap = new HashMap<String,TSecStatPoint>(2*_map0.size);
                for (int _i1 = 0; _i1 < _map0.size; ++_i1)
                {
                  String _key2; // required
                  TSecStatPoint _val3; // required
                  _key2 = iprot.readString();
                  _val3 = new TSecStatPoint();
                  _val3.read(iprot);
                  struct.secondMap.put(_key2, _val3);
                }
                iprot.readMapEnd();
              }
              struct.setSecondMapIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // MINUTE_MAP
            if (schemeField.type == org.apache.thrift.protocol.TType.MAP) {
              {
                org.apache.thrift.protocol.TMap _map4 = iprot.readMapBegin();
                struct.minuteMap = new HashMap<String,TMinStatPoint>(2*_map4.size);
                for (int _i5 = 0; _i5 < _map4.size; ++_i5)
                {
                  String _key6; // required
                  TMinStatPoint _val7; // required
                  _key6 = iprot.readString();
                  _val7 = new TMinStatPoint();
                  _val7.read(iprot);
                  struct.minuteMap.put(_key6, _val7);
                }
                iprot.readMapEnd();
              }
              struct.setMinuteMapIsSet(true);
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
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, TMapStatPoint struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.secondMap != null) {
        if (struct.isSetSecondMap()) {
          oprot.writeFieldBegin(SECOND_MAP_FIELD_DESC);
          {
            oprot.writeMapBegin(new org.apache.thrift.protocol.TMap(org.apache.thrift.protocol.TType.STRING, org.apache.thrift.protocol.TType.STRUCT, struct.secondMap.size()));
            for (Map.Entry<String, TSecStatPoint> _iter8 : struct.secondMap.entrySet())
            {
              oprot.writeString(_iter8.getKey());
              _iter8.getValue().write(oprot);
            }
            oprot.writeMapEnd();
          }
          oprot.writeFieldEnd();
        }
      }
      if (struct.minuteMap != null) {
        if (struct.isSetMinuteMap()) {
          oprot.writeFieldBegin(MINUTE_MAP_FIELD_DESC);
          {
            oprot.writeMapBegin(new org.apache.thrift.protocol.TMap(org.apache.thrift.protocol.TType.STRING, org.apache.thrift.protocol.TType.STRUCT, struct.minuteMap.size()));
            for (Map.Entry<String, TMinStatPoint> _iter9 : struct.minuteMap.entrySet())
            {
              oprot.writeString(_iter9.getKey());
              _iter9.getValue().write(oprot);
            }
            oprot.writeMapEnd();
          }
          oprot.writeFieldEnd();
        }
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class TMapStatPointTupleSchemeFactory implements SchemeFactory {
    public TMapStatPointTupleScheme getScheme() {
      return new TMapStatPointTupleScheme();
    }
  }

  private static class TMapStatPointTupleScheme extends TupleScheme<TMapStatPoint> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, TMapStatPoint struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetSecondMap()) {
        optionals.set(0);
      }
      if (struct.isSetMinuteMap()) {
        optionals.set(1);
      }
      oprot.writeBitSet(optionals, 2);
      if (struct.isSetSecondMap()) {
        {
          oprot.writeI32(struct.secondMap.size());
          for (Map.Entry<String, TSecStatPoint> _iter10 : struct.secondMap.entrySet())
          {
            oprot.writeString(_iter10.getKey());
            _iter10.getValue().write(oprot);
          }
        }
      }
      if (struct.isSetMinuteMap()) {
        {
          oprot.writeI32(struct.minuteMap.size());
          for (Map.Entry<String, TMinStatPoint> _iter11 : struct.minuteMap.entrySet())
          {
            oprot.writeString(_iter11.getKey());
            _iter11.getValue().write(oprot);
          }
        }
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, TMapStatPoint struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(2);
      if (incoming.get(0)) {
        {
          org.apache.thrift.protocol.TMap _map12 = new org.apache.thrift.protocol.TMap(org.apache.thrift.protocol.TType.STRING, org.apache.thrift.protocol.TType.STRUCT, iprot.readI32());
          struct.secondMap = new HashMap<String,TSecStatPoint>(2*_map12.size);
          for (int _i13 = 0; _i13 < _map12.size; ++_i13)
          {
            String _key14; // required
            TSecStatPoint _val15; // required
            _key14 = iprot.readString();
            _val15 = new TSecStatPoint();
            _val15.read(iprot);
            struct.secondMap.put(_key14, _val15);
          }
        }
        struct.setSecondMapIsSet(true);
      }
      if (incoming.get(1)) {
        {
          org.apache.thrift.protocol.TMap _map16 = new org.apache.thrift.protocol.TMap(org.apache.thrift.protocol.TType.STRING, org.apache.thrift.protocol.TType.STRUCT, iprot.readI32());
          struct.minuteMap = new HashMap<String,TMinStatPoint>(2*_map16.size);
          for (int _i17 = 0; _i17 < _map16.size; ++_i17)
          {
            String _key18; // required
            TMinStatPoint _val19; // required
            _key18 = iprot.readString();
            _val19 = new TMinStatPoint();
            _val19.read(iprot);
            struct.minuteMap.put(_key18, _val19);
          }
        }
        struct.setMinuteMapIsSet(true);
      }
    }
  }

}
