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

ALTERNATIVE_PRIORITY = "100"

ALTERNATIVE_${PN} = "compare composite conjure convert identify mogrify \
    montage stream"

ALTERNATIVE_TARGET[compare] = "${bindir}/gm"
ALTERNATIVE_TARGET[composite] = "${bindir}/gm"
ALTERNATIVE_TARGET[conjure] = "${bindir}/gm"
ALTERNATIVE_TARGET[convert] = "${bindir}/gm"
ALTERNATIVE_TARGET[identify] = "${bindir}/gm"
ALTERNATIVE_TARGET[mogrify] = "${bindir}/gm"
ALTERNATIVE_TARGET[montage] = "${bindir}/gm"
ALTERNATIVE_TARGET[stream] = "${bindir}/gm"

ALTERNATIVE_${PN}-doc = "compare.1 composite.1 conjure.1 convert.1 \
    identify.1 mogrify.1 montage.1 stream.1"

ALTERNATIVE_LINK_NAME[compare.1] = "${mandir}/man1/compare.1"
ALTERNATIVE_TARGET[compare.1] = "${mandir}/man1/gm.1"
ALTERNATIVE_LINK_NAME[composite.1] = "${mandir}/man1/composite.1"
ALTERNATIVE_TARGET[composite.1] = "${mandir}/man1/gm.1"
ALTERNATIVE_LINK_NAME[conjure.1] = "${mandir}/man1/conjure.1"
ALTERNATIVE_TARGET[conjure.1] = "${mandir}/man1/gm.1"
ALTERNATIVE_LINK_NAME[convert.1] = "${mandir}/man1/convert.1"
ALTERNATIVE_TARGET[convert.1] = "${mandir}/man1/gm.1"
ALTERNATIVE_LINK_NAME[identify.1] = "${mandir}/man1/identify.1"
ALTERNATIVE_TARGET[identify.1] = "${mandir}/man1/gm.1"
ALTERNATIVE_LINK_NAME[mogrify.1] = "${mandir}/man1/mogrify.1"
ALTERNATIVE_TARGET[mogrify.1] = "${mandir}/man1/gm.1"
ALTERNATIVE_LINK_NAME[montage.1] = "${mandir}/man1/montage.1"
ALTERNATIVE_TARGET[montage.1] = "${mandir}/man1/gm.1"
ALTERNATIVE_LINK_NAME[stream.1] = "${mandir}/man1/stream.1"
ALTERNATIVE_TARGET[stream.1] = "${mandir}/man1/gm.1"
