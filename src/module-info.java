/**
 * 
 */
/**
 * 
 */
module FcBank {
	requires com.google.gson;
    requires com.fasterxml.jackson.core;
    requires com.fasterxml.jackson.databind;
    requires com.fasterxml.jackson.dataformat.xml;
	requires com.fasterxml.jackson.annotation;
    
    opens main.components to com.google.gson ,com.fasterxml.jackson.databind;

    exports main.components;
}