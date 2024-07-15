### Serializable

When to use transient ?

    If you don't want to serialize a field.

What is serialVersionUID used for ?

    To keep track of version. For example you have a class with serialVersionUID=1, and at that moment
    you have two fields declared with type string and later if you want to change the type of the field to int.
    You don't want to allow the data serialized with first version for the new version.

    You can manage versions. Its kind of versionManagement for object streams
 