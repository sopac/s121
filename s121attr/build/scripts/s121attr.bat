@if "%DEBUG%" == "" @echo off
@rem ##########################################################################
@rem
@rem  s121attr startup script for Windows
@rem
@rem ##########################################################################

@rem Set local scope for the variables with windows NT shell
if "%OS%"=="Windows_NT" setlocal

set DIRNAME=%~dp0
if "%DIRNAME%" == "" set DIRNAME=.
set APP_BASE_NAME=%~n0
set APP_HOME=%DIRNAME%..

@rem Add default JVM options here. You can also use JAVA_OPTS and S121ATTR_OPTS to pass JVM options to this script.
set DEFAULT_JVM_OPTS=

@rem Find java.exe
if defined JAVA_HOME goto findJavaFromJavaHome

set JAVA_EXE=java.exe
%JAVA_EXE% -version >NUL 2>&1
if "%ERRORLEVEL%" == "0" goto init

echo.
echo ERROR: JAVA_HOME is not set and no 'java' command could be found in your PATH.
echo.
echo Please set the JAVA_HOME variable in your environment to match the
echo location of your Java installation.

goto fail

:findJavaFromJavaHome
set JAVA_HOME=%JAVA_HOME:"=%
set JAVA_EXE=%JAVA_HOME%/bin/java.exe

if exist "%JAVA_EXE%" goto init

echo.
echo ERROR: JAVA_HOME is set to an invalid directory: %JAVA_HOME%
echo.
echo Please set the JAVA_HOME variable in your environment to match the
echo location of your Java installation.

goto fail

:init
@rem Get command-line arguments, handling Windows variants

if not "%OS%" == "Windows_NT" goto win9xME_args
if "%@eval[2+2]" == "4" goto 4NT_args

:win9xME_args
@rem Slurp the command line arguments.
set CMD_LINE_ARGS=
set _SKIP=2

:win9xME_args_slurp
if "x%~1" == "x" goto execute

set CMD_LINE_ARGS=%*
goto execute

:4NT_args
@rem Get arguments from the 4NT Shell from JP Software
set CMD_LINE_ARGS=%$

:execute
@rem Setup the command line

set CLASSPATH=%APP_HOME%\lib\s121attr-1.0-SNAPSHOT.jar;%APP_HOME%\lib\groovy-all-2.4.6.jar;%APP_HOME%\lib\geoscript-groovy-1.7.0.jar;%APP_HOME%\lib\java-vector-tile-1.0.9.jar;%APP_HOME%\lib\gt-main-15.0.jar;%APP_HOME%\lib\gt-epsg-hsql-15.0.jar;%APP_HOME%\lib\gt-render-15.0.jar;%APP_HOME%\lib\gt-shapefile-15.0.jar;%APP_HOME%\lib\gt-jdbc-postgis-15.0.jar;%APP_HOME%\lib\gt-jdbc-h2-15.0.jar;%APP_HOME%\lib\gt-jdbc-mysql-15.0.jar;%APP_HOME%\lib\gt-jdbc-spatialite-15.0.jar;%APP_HOME%\lib\gt-xsd-wfs-15.0.jar;%APP_HOME%\lib\gt-wfs-ng-15.0.jar;%APP_HOME%\lib\gt-charts-15.0.jar;%APP_HOME%\lib\gt-brewer-15.0.jar;%APP_HOME%\lib\gt-svg-15.0.jar;%APP_HOME%\lib\gt-property-15.0.jar;%APP_HOME%\lib\gt-geojson-15.0.jar;%APP_HOME%\lib\gt-swing-15.0.jar;%APP_HOME%\lib\gt-process-15.0.jar;%APP_HOME%\lib\gt-process-feature-15.0.jar;%APP_HOME%\lib\gt-process-geometry-15.0.jar;%APP_HOME%\lib\gt-xsd-kml-15.0.jar;%APP_HOME%\lib\gt-css-15.0.jar;%APP_HOME%\lib\gt-ysld-15.0.jar;%APP_HOME%\lib\gt-geotiff-15.0.jar;%APP_HOME%\lib\gt-image-15.0.jar;%APP_HOME%\lib\gt-imagemosaic-15.0.jar;%APP_HOME%\lib\gt-arcgrid-15.0.jar;%APP_HOME%\lib\gt-grassraster-15.0.jar;%APP_HOME%\lib\gt-gtopo30-15.0.jar;%APP_HOME%\lib\gt-imagepyramid-15.0.jar;%APP_HOME%\lib\gt-imageio-ext-gdal-15.0.jar;%APP_HOME%\lib\gt-netcdf-15.0.jar;%APP_HOME%\lib\gt-process-raster-15.0.jar;%APP_HOME%\lib\gt-wms-15.0.jar;%APP_HOME%\lib\gt-transform-15.0.jar;%APP_HOME%\lib\gt-mbtiles-15.0.jar;%APP_HOME%\lib\gt-geopkg-15.0.jar;%APP_HOME%\lib\gt-grid-15.0.jar;%APP_HOME%\lib\gt-geobuf-15.0.jar;%APP_HOME%\lib\gdal-1.11.2.jar;%APP_HOME%\lib\gt-ogr-jni-15.0.jar;%APP_HOME%\lib\jt-jiffleop-0.2.0.jar;%APP_HOME%\lib\jt-jiffle-language-0.2.0.jar;%APP_HOME%\lib\opencsv-3.7.jar;%APP_HOME%\lib\itext-2.1.7.jar;%APP_HOME%\lib\jts-1.13.jar;%APP_HOME%\lib\protobuf-javanano-3.0.0-alpha-2.jar;%APP_HOME%\lib\gt-api-15.0.jar;%APP_HOME%\lib\jdom-1.1.3.jar;%APP_HOME%\lib\jai_core-1.1.3.jar;%APP_HOME%\lib\gt-referencing-15.0.jar;%APP_HOME%\lib\hsqldb-2.3.0.jar;%APP_HOME%\lib\gt-coverage-15.0.jar;%APP_HOME%\lib\gt-cql-15.0.jar;%APP_HOME%\lib\gt-data-15.0.jar;%APP_HOME%\lib\postgresql-9.4-1201-jdbc41.jar;%APP_HOME%\lib\gt-jdbc-15.0.jar;%APP_HOME%\lib\geodb-0.7-RC2.jar;%APP_HOME%\lib\h2-1.1.119.jar;%APP_HOME%\lib\mysql-connector-java-5.1.17.jar;%APP_HOME%\lib\spatialite-jdbc-3.7.2-2.4.jar;%APP_HOME%\lib\net.opengis.wfs-15.0.jar;%APP_HOME%\lib\gt-xsd-filter-15.0.jar;%APP_HOME%\lib\gt-xsd-fes-15.0.jar;%APP_HOME%\lib\gt-xsd-ows-15.0.jar;%APP_HOME%\lib\gt-complex-15.0.jar;%APP_HOME%\lib\gt-xsd-gml3-15.0.jar;%APP_HOME%\lib\gt-xml-15.0.jar;%APP_HOME%\lib\xpp3_min-1.1.4c.jar;%APP_HOME%\lib\commons-httpclient-3.1.jar;%APP_HOME%\lib\commons-io-2.1.jar;%APP_HOME%\lib\xmlunit-1.3.jar;%APP_HOME%\lib\eastwood-1.1.1-20090908.jar;%APP_HOME%\lib\batik-transcoder-1.7.jar;%APP_HOME%\lib\json-simple-1.1.jar;%APP_HOME%\lib\commons-lang-2.6.jar;%APP_HOME%\lib\miglayout-3.7-swing.jar;%APP_HOME%\lib\jai_imageio-1.1.jar;%APP_HOME%\lib\gt-xsd-core-15.0.jar;%APP_HOME%\lib\parboiled-java-1.1.7.jar;%APP_HOME%\lib\gt-xsd-sld-15.0.jar;%APP_HOME%\lib\snakeyaml-1.13.jar;%APP_HOME%\lib\jsr305-3.0.0.jar;%APP_HOME%\lib\imageio-ext-tiff-1.1.13.jar;%APP_HOME%\lib\jsr-275-1.0-beta-2.jar;%APP_HOME%\lib\imageio-ext-streams-1.1.13.jar;%APP_HOME%\lib\imageio-ext-geocore-1.1.13.jar;%APP_HOME%\lib\commons-beanutils-1.7.0.jar;%APP_HOME%\lib\jt-utils-1.4.0.jar;%APP_HOME%\lib\jt-vectorbinarize-1.4.0.jar;%APP_HOME%\lib\ehcache-1.6.2.jar;%APP_HOME%\lib\jai_codec-1.1.3.jar;%APP_HOME%\lib\imageio-ext-arcgrid-1.1.13.jar;%APP_HOME%\lib\imageio-ext-gdalarcbinarygrid-1.1.13.jar;%APP_HOME%\lib\imageio-ext-gdalmrsid-1.1.13.jar;%APP_HOME%\lib\imageio-ext-gdalecw-1.1.13.jar;%APP_HOME%\lib\imageio-ext-gdaldted-1.1.13.jar;%APP_HOME%\lib\imageio-ext-gdalkakadujp2-1.1.13.jar;%APP_HOME%\lib\imageio-ext-gdalmrsidjp2-1.1.13.jar;%APP_HOME%\lib\imageio-ext-gdalecwjp2-1.1.13.jar;%APP_HOME%\lib\imageio-ext-gdalehdr-1.1.13.jar;%APP_HOME%\lib\imageio-ext-gdalenvihdr-1.1.13.jar;%APP_HOME%\lib\imageio-ext-gdalerdasimg-1.1.13.jar;%APP_HOME%\lib\imageio-ext-gdalnitf-1.1.13.jar;%APP_HOME%\lib\imageio-ext-gdalrpftoc-1.1.13.jar;%APP_HOME%\lib\imageio-ext-gdalidrisi-1.1.13.jar;%APP_HOME%\lib\imageio-ext-imagereadmt-1.1.13.jar;%APP_HOME%\lib\gt-coverage-api-15.0.jar;%APP_HOME%\lib\imageio-ext-utilities-1.1.13.jar;%APP_HOME%\lib\cdm-4.6.2.jar;%APP_HOME%\lib\netcdf4-4.6.2.jar;%APP_HOME%\lib\bufr-4.6.2.jar;%APP_HOME%\lib\opendap-2.1.jar;%APP_HOME%\lib\slf4j-log4j12-1.6.4.jar;%APP_HOME%\lib\jt-zonalstats-1.4.0.jar;%APP_HOME%\lib\jt-rangelookup-1.4.0.jar;%APP_HOME%\lib\jt-contour-1.4.0.jar;%APP_HOME%\lib\jt-vectorize-1.4.0.jar;%APP_HOME%\lib\sqlite-jdbc-3.8.6.jar;%APP_HOME%\lib\protobuf-java-2.6.1.jar;%APP_HOME%\lib\gt-ogr-core-15.0.jar;%APP_HOME%\lib\antlr-3.3.jar;%APP_HOME%\lib\janino-2.5.16.jar;%APP_HOME%\lib\commons-lang3-3.3.2.jar;%APP_HOME%\lib\core-0.26.jar;%APP_HOME%\lib\commons-pool-1.5.4.jar;%APP_HOME%\lib\gt-metadata-15.0.jar;%APP_HOME%\lib\jgridshift-1.0.jar;%APP_HOME%\lib\GeographicLib-Java-1.44.jar;%APP_HOME%\lib\jt-affine-1.0.9.jar;%APP_HOME%\lib\jt-algebra-1.0.9.jar;%APP_HOME%\lib\jt-bandmerge-1.0.9.jar;%APP_HOME%\lib\jt-bandselect-1.0.9.jar;%APP_HOME%\lib\jt-bandcombine-1.0.9.jar;%APP_HOME%\lib\jt-border-1.0.9.jar;%APP_HOME%\lib\jt-buffer-1.0.9.jar;%APP_HOME%\lib\jt-crop-1.0.9.jar;%APP_HOME%\lib\jt-lookup-1.0.9.jar;%APP_HOME%\lib\jt-mosaic-1.0.9.jar;%APP_HOME%\lib\jt-nullop-1.0.9.jar;%APP_HOME%\lib\jt-rescale-1.0.9.jar;%APP_HOME%\lib\jt-stats-1.0.9.jar;%APP_HOME%\lib\jt-warp-1.0.9.jar;%APP_HOME%\lib\jt-zonal-1.0.9.jar;%APP_HOME%\lib\jt-binarize-1.0.9.jar;%APP_HOME%\lib\jt-format-1.0.9.jar;%APP_HOME%\lib\jt-colorconvert-1.0.9.jar;%APP_HOME%\lib\jt-errordiffusion-1.0.9.jar;%APP_HOME%\lib\jt-orderdither-1.0.9.jar;%APP_HOME%\lib\jt-colorindexer-1.0.9.jar;%APP_HOME%\lib\jt-imagefunction-1.0.9.jar;%APP_HOME%\lib\jt-piecewise-1.0.9.jar;%APP_HOME%\lib\jt-classifier-1.0.9.jar;%APP_HOME%\lib\jt-rlookup-1.0.9.jar;%APP_HOME%\lib\jt-vectorbin-1.0.9.jar;%APP_HOME%\lib\commons-dbcp-1.4.jar;%APP_HOME%\lib\commons-collections-3.2.2.jar;%APP_HOME%\lib\hatbox-1.0.b7.jar;%APP_HOME%\lib\org.w3.xlink-15.0.jar;%APP_HOME%\lib\net.opengis.fes-15.0.jar;%APP_HOME%\lib\common-2.6.0.jar;%APP_HOME%\lib\ecore-2.6.1.jar;%APP_HOME%\lib\gt-xsd-gml2-15.0.jar;%APP_HOME%\lib\net.opengis.ows-15.0.jar;%APP_HOME%\lib\gt-app-schema-resolver-15.0.jar;%APP_HOME%\lib\xml-commons-resolver-1.2.jar;%APP_HOME%\lib\jfreechart-1.0.10.jar;%APP_HOME%\lib\jcommon-1.0.13.jar;%APP_HOME%\lib\junit-3.8.2.jar;%APP_HOME%\lib\fop-0.94.jar;%APP_HOME%\lib\batik-awt-util-1.7.jar;%APP_HOME%\lib\batik-bridge-1.7.jar;%APP_HOME%\lib\batik-dom-1.7.jar;%APP_HOME%\lib\batik-gvt-1.7.jar;%APP_HOME%\lib\batik-svg-dom-1.7.jar;%APP_HOME%\lib\batik-svggen-1.7.jar;%APP_HOME%\lib\batik-util-1.7.jar;%APP_HOME%\lib\batik-xml-1.7.jar;%APP_HOME%\lib\xml-apis-ext-1.3.04.jar;%APP_HOME%\lib\gt-graph-15.0.jar;%APP_HOME%\lib\picocontainer-1.2.jar;%APP_HOME%\lib\commons-jxpath-1.3.jar;%APP_HOME%\lib\xsd-2.6.0.jar;%APP_HOME%\lib\parboiled-core-1.1.7.jar;%APP_HOME%\lib\asm-5.0.3.jar;%APP_HOME%\lib\asm-tree-5.0.3.jar;%APP_HOME%\lib\asm-analysis-5.0.3.jar;%APP_HOME%\lib\asm-util-5.0.3.jar;%APP_HOME%\lib\imageio-ext-gdalframework-1.1.13.jar;%APP_HOME%\lib\net.opengis.wcs-15.0.jar;%APP_HOME%\lib\udunits-4.6.2.jar;%APP_HOME%\lib\httpservices-4.6.2.jar;%APP_HOME%\lib\httpcore-4.3.3.jar;%APP_HOME%\lib\joda-time-2.2.jar;%APP_HOME%\lib\jdom2-2.0.4.jar;%APP_HOME%\lib\jcip-annotations-1.0.jar;%APP_HOME%\lib\quartz-2.2.0.jar;%APP_HOME%\lib\guava-18.0.jar;%APP_HOME%\lib\jcommander-1.35.jar;%APP_HOME%\lib\slf4j-api-1.7.7.jar;%APP_HOME%\lib\jna-4.1.0.jar;%APP_HOME%\lib\log4j-1.2.16.jar;%APP_HOME%\lib\jt-attributeop-1.4.0.jar;%APP_HOME%\lib\antlr-runtime-3.3.jar;%APP_HOME%\lib\gt-opengis-15.0.jar;%APP_HOME%\lib\jt-iterators-1.0.9.jar;%APP_HOME%\lib\jt-utilities-1.0.9.jar;%APP_HOME%\lib\jt-scale-1.0.9.jar;%APP_HOME%\lib\xmlgraphics-commons-1.2.jar;%APP_HOME%\lib\avalon-framework-api-4.3.1.jar;%APP_HOME%\lib\avalon-framework-impl-4.3.1.jar;%APP_HOME%\lib\batik-anim-1.7.jar;%APP_HOME%\lib\batik-css-1.7.jar;%APP_HOME%\lib\batik-ext-1.7.jar;%APP_HOME%\lib\batik-parser-1.7.jar;%APP_HOME%\lib\batik-script-1.7.jar;%APP_HOME%\lib\xalan-2.6.0.jar;%APP_HOME%\lib\imageio-ext-gdal-bindings-1.9.2.jar;%APP_HOME%\lib\httpclient-4.3.6.jar;%APP_HOME%\lib\c3p0-0.9.1.1.jar;%APP_HOME%\lib\stringtemplate-3.2.1.jar;%APP_HOME%\lib\jt-translate-1.0.9.jar;%APP_HOME%\lib\batik-js-1.7.jar;%APP_HOME%\lib\antlr-2.7.7.jar;%APP_HOME%\lib\commons-logging-1.1.3.jar;%APP_HOME%\lib\xml-apis-2.0.2.jar;%APP_HOME%\lib\commons-codec-1.6.jar

@rem Execute s121attr
"%JAVA_EXE%" %DEFAULT_JVM_OPTS% %JAVA_OPTS% %S121ATTR_OPTS%  -classpath "%CLASSPATH%" Main %CMD_LINE_ARGS%

:end
@rem End local scope for the variables with windows NT shell
if "%ERRORLEVEL%"=="0" goto mainEnd

:fail
rem Set variable S121ATTR_EXIT_CONSOLE if you need the _script_ return code instead of
rem the _cmd.exe /c_ return code!
if  not "" == "%S121ATTR_EXIT_CONSOLE%" exit 1
exit /b 1

:mainEnd
if "%OS%"=="Windows_NT" endlocal

:omega
