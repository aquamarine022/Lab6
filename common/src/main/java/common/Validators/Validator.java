package common.Validators;


import common.Exceptions.InvalidDataException;

/**
 * interface for validatable classes
 */
@FunctionalInterface
public interface Validator<T> {
    void validate(T value) throws InvalidDataException;
}
