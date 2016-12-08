#Tutorial background information

##File structure

<p>To get started with the basic concepts of MetaFactory and your first lines of pattern code, we recommend that you first read our    <a href="https://www.metafactory.nl/document/quick-start/">‘Quick Start’ documentation</a>. This tutorial elaborates on the former in a step by step way to teach you all the important things you need in coding your project patterns.
As you should be familiar with from our Quick Start, MetaFactory projects rely on 3 files; a project file (metafactory.xml) for all project configuration, a pattern file (pattern.xml) that contains your application code instructions and a model (model.xml) that holds all domain specific data and metadata. All tutorials follow this structure, so you should know now which files belong together.
Since extensive documentation about the various MetaFactory concepts and coding structure can be found in our Quickstart and other documentation, we will refer to this documentation in these tutorials rather than repeating that information.</p>

##Example 1

<p>This first example naturally is about ‘Hello World’, which simply generates a Java class with main method and a printLine.</p> 

##Example 1 with expressions

<p>This example takes the concept of Hello world to a higer level with added expressions as the most notable feature. Take a look at the pattern while comparing it to the previous tutorial and you will notice a huge difference. Many names are now no longer hard coded, but replaced by expressions instead. These expressions (such as in pattern.with-expressions.xml) use properties that we can define ourselves in the patterns. Read more about pattern properties <a href="https://www.metafactory.nl/document/pattern-reference/pattern-properties/">here</a>.
Expressions such as ${object.name} are known at the time of execution because a pattern is always executed within the context of the part of the domain model that MetaFactory is iterating over, such as a package, object or property. Read more about expressions <a href="https://www.metafactory.nl/document/expressions-2/">here</a>.</p>
<p>We recommend you to generate the code of this example yourself, after changing <java.output.directory>generated/src/main/java</java.output.directory> into a location of your own choice. Try and play around with the other properties as well.</p>

##Example 2

<p>Writing all code instructions in pattern.xml quickly becomes messy. It is therefore recommended to separate concerns in different pattern files. The most obvious one is it to include a pattern the xml way through ’xi:include’, which is shown in example 2a.</p>
   <p>The other way is to include a pattern file which is in a different project altogether, for example your very own library. Example 2b uses a pattern from the <a href="https://github.com/MetaFactory/metafactory-library">metafactory-library</a> project. Therefore to generated the code of Example 2b you will need to first clone the metafactory-library and update the path to lib1.</p> 
   <p>Both examples generate a series of Java POJOs, for which al objects and including properties are drawn from model2.xml.</p>

##Example 3

<p>Example 3 does the same as example 2b, but the generated POJOs are now more advanced, with an added equals, hashCode and toString method. The external package from metafactory-library that is referred to relies heavily on expressions for naming as well as conditions that determine whether a piece of code is actually generated. Another concept that is new here is the use of snippets, which MetaFactory supports in either Freemarker of Velocity format.
 Snippets are pieces of code that you can load from a template into your pattern like this: ${fmsnippet.condition.reference_1_and_enum} – which checks whether the object reference MetaFactory is currently iterating over has a multiplicity of 0..1 or 1..1 and is not an enum. After ‘fmsnippet’ follows the name of the file. Also note that an external library is used in this example (‘lib1), which is defined in pattern3.xml. You can read more about this subject <a href="https://www.metafactory.nl/document/pattern-reference/external-libraries/">here</a>.</p>
 
##Example 4

<p>Note that this example uses exactly the same pattern as the previous one. The difference lies in the addition of some metadata to the model, which in combination with the pattern produces different generated code. Look how the creation of the constructor is now controlled by the added metadata.</p>

##Example 5

<p>In comparison to the previous example a few things have changed. Most importantly the external package that has been imported in pattern5.xml to code the POJO has been replaced by a different one (model-jpa2.xml). Since this other pattern requires some additional metadata, new properties have been added to the model. Note that a property called 

```
<serialVersionUID>
```

 has now been added to each object.</p>

##Example 6

<p>In this example we’ve added a pattern that generates DAO classes next to the POJOs. It uses the same data model but does require some additional model properties, which as you can see have been added to pattern6.xml. Also model6.xml contains additional properties, such as projectspecific.fillComboForAdd, which is called from one of the included snippet in jpa2-cdi-dao-beans.xml. Note how can easily change the data for both POJO and DAO at once by changing the model.</p>

##Example 7

<p>This example again uses the same external pattern packages, but some new metadata added in the form of both pattern and model properties. The most important one introduces a new mechanism that we call 'metadata-matching'</>
<p> With metadata matching you can introduce an object property (for example < dao.finder.single.key>Fields</dao.finder.single.key > and then use that property in the form of "< dao.finder.single.key.Fields />" at attribute/reference level. 
What this in fact does is that you define a keyname, which you can bind to attributes by using that second step. Given that this key is bound to (in the case of object 'Company') to attribute "name" and "phone" we now have the information we need to do something specific with only these attributes. By first defining the key and then looping over the results that MetaFactory finds, we can create specific finder methods that accept only these attributes as parameters.<p>
The same principle holds for example if you would want to define a unique key constraint on a table. You would then define something like < unique.key.companyUniqueKey />.

We used this mechanism also in example 4 to create 2 constructors in the Relation class with different parameters.




