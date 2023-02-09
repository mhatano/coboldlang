# Programming Language Cobold 0.1

Programming Language Cobold is C syntax based, Java inspired newly developed programming language which can implement methods and its contract for detecting programming errors more quickly.

Since the name of the language is too much nearer to the existing totally different programming langauge COBOL, name would be re-considered in near future.

Cobold name is inspired by COntract By Design, where o and l are from nowhere.

Original spelling of the monster is Kobold, but replacing K with C shows the origin of the language as it is the derivarative of the programming language C.

```Java
pragma compiletarget java;
class Example {
    attributes {
        visibility : public;
    }

    members {
        main : class method;
        helloWorld : instance method;
        lastName : class variable, nullable;
    }

    declarations {
        declaration lastName {
            attributes {
                visibility : private;
                type : String;
                initialvalue : null;
            }
            imports
                String : java.lang.String;
        }

        declaration main {
            attributes {
                visibility : public;
                return : void;
            }
            assets {
                arguments
                    arg : arrayof String;
                locals
                    main : instanceof Example;
            }
            contracts {
                arguments
                    arg : unlimitedlength, nullable, immutable;
                locals
                    main : nonnull, nonderived;
            } 
            imports
                String : java.lang.String;
        }
        declaration helloWorld {
            attributes {
                visibility : public;
                return void;
            }
            assets {
                arguments {
                    name : instanceof String;
                    savelast : boolean;
                }
                locals {
                    copyOfName : instanceof String;
                    stringBuilder : instanceof StringBuilder;
                }
                constants
                    defaultname : "world";
                imports {
                    System : java.lang.System;
                    Character : java.lang.Character;
                    String : java.lang.String;
                    StringBuilder : java.lang.StringBuilder;
                    Supplier : java.lang.function.Supplier;
                }
            }
            contracts {
                arguments
                    name : nullable, immutable;
                locals
                    supplierCopyOfName : nonnull, immutable, initializedatassignment;
                    copyOfName : nonnull, immutable, initializeatassignment;
            }
        }
    }

    implementations {
        implementation main {
            Example main = new Example();
            main.helloWorld(defaultname);
            return;
        }

        implementation helloWorld {
            copyOfName = ((Supplier<String>)(() -> {
                if ( name == null && lastName == null ) {
                    return "World";
                } else if ( name == null ) {
                    return lastName;
                } else if ( name.charAt(0).isLower() ) {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(Character.toUpperCase(name.charAt(0)));
                    stringBuilder.append(name.substring(1));
                    return stringBuilder.toString();
                } else {
                    return name.clone();
                }
            })).get();
            System.out.printf("Hello, %s!\n",copyOfName);
            if ( savelast ) {
                lastName = copyOfName;
            }
        }
    }
}
```
