SUMMARY = "GraphicsMagick is an image convertion tools"
SECTION = "console/utils"
LICENSE = "GraphicsMagick"
LIC_FILES_CHKSUM = "file://Copyright.txt;md5=4a6c2bb033f63e159cb036de999593a6"
# FIXME: There are many more checked libraries. All should be added or explicitly disabled to get consistent results.
DEPENDS = "lcms bzip2 jpeg libpng librsvg tiff zlib virtual/fftw freetype"

SRC_URI = "http://downloads.sourceforge.net/project/graphicsmagick/graphicsmagick/1.3.23/GraphicsMagick-${PV}.tar.xz \
"
SRC_URI[md5sum] = "9885ff5d91bc215a0adb3be1185e9777"
SRC_URI[sha256sum] = "fd2535a529528ec6f0bd493fed4395e08082faf940d51d7c18c25586a0a0e60d"

S = "${WORKDIR}/GraphicsMagick-${PV}"

inherit autotools pkgconfig update-alternatives

# xml disabled because it's using xml2-config --prefix to determine prefix which returns just /usr with our libxml2
# if someone needs xml support then fix it first
EXTRA_OECONF = "--without-magick-plus-plus --without-xml --without-x --without-perl"

CACHED_CONFIGUREVARS = "ac_cv_sys_file_offset_bits=yes"
PACKAGECONFIG[jp2] = "--with-jp2,--without-jp2,jasper"
PACKAGECONFIG[lzma] = "--with-lzma,--without-lzma,xz"
PACKAGECONFIG[wmf] = "--with-wmf,--without-wmf,libwmf"

FILES_${PN} += "${libdir}/GraphicsMagick-${PV}/config \
                ${datadir}/GraphicsMagick-${PV} "

BBCLASSEXTEND = "native"
