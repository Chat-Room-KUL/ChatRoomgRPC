// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: calculator.proto

package be.msec.labgrpc;

public interface CalculationOrBuilder extends
    // @@protoc_insertion_point(interface_extends:tutorial.Calculation)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>int32 index = 1;</code>
   */
  int getIndex();

  /**
   * <code>.tutorial.Sum sum = 2;</code>
   */
  boolean hasSum();
  /**
   * <code>.tutorial.Sum sum = 2;</code>
   */
  be.msec.labgrpc.Sum getSum();
  /**
   * <code>.tutorial.Sum sum = 2;</code>
   */
  be.msec.labgrpc.SumOrBuilder getSumOrBuilder();

  /**
   * <code>.tutorial.CalculatorReply solution = 3;</code>
   */
  boolean hasSolution();
  /**
   * <code>.tutorial.CalculatorReply solution = 3;</code>
   */
  be.msec.labgrpc.CalculatorReply getSolution();
  /**
   * <code>.tutorial.CalculatorReply solution = 3;</code>
   */
  be.msec.labgrpc.CalculatorReplyOrBuilder getSolutionOrBuilder();
}