package com.kshitij.learnreactive.design;

/**
 * It is used when we have to make copy/clone from existing object.
 * We want to copy object and make some minor modifications.
 * creating an object is expensive here.
 * prototype pattern is used when we have to make a clone from existing object and creating of existing object is highly expensive.
 */
public interface Prototype {
    Prototype clone();
}
