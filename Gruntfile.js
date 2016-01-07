module.exports = function (grunt) {
	grunt.initConfig({
		concat: {
			js: {// concat��������һ��task, ��������ִ��
				options: {
					separator: ';',
					process: {
						data: {
							baseUrl: './',
							requireJSVersion: +new Date
						}
					}
				},
				files: {
					'./javascript/lib/require.js': ['./javascript/lib/config.js', './bower_components/requirejs/require.js'],
					'./javascript/lib/backbone.js': ['./bower_components/backbone/backbone-min.js', './bower_components/backbone.modelBinder/Backbone.ModelBinder.min.js']
				}
			},
			css: {
				options: {
					seperator: ';'
				},
				files: {
					'./style/common/prettify.css': ['./bower_components/code-prettify/src/prettify.css', './bower_components/code-prettify/loader/skin/sunburst.css']
				}
			}
		},
		copy: {
			css: {
				files: {
					'./style/common/normalize.css': './bower_components/normalize-css/normalize.css'
				}
			},
			js: {
				files: {
					'./javascript/lib/jquery.js': './bower_components/jquery/dist/jquery.min.js',
					'./javascript/lib/prettify.js': './bower_components/code-prettify/src/run_prettify.js',
					'./javascript/lib/underscore.js': './bower_components/underscore/underscore-min.js',
					'./javascript/lib/handlebars.runtime.js': './bower_components/handlebars/handlebars.runtime.min.js'
				}
			}
		},
		cssmin: {
			'./style/common/normalize.css': './style/common/normalize.css',
			'./style/common/prettify.css': './style/common/prettify.css'
		},
        stylus: {
            options: {
				paths: ['./style/common'],//��Ҫ���path, ������Ҳ�����Ҫimport���ļ�
                'include css': true
            },
            compile: {
                files: {
					'./style/notes.css': './style/common/notes.styl',
					'./style/home.css': './style/pages/home.styl',
					'./style/pageView.css': './style/pages/pageView.styl'
                }
            }
        },
		handlebars: {
			compile: {
				options: {
					amd: true,
					namespace: 'template',
					processContent: function (content, filepath) {
						content = content.replace(/^[\x20\t]+/mg, '').replace(/[\x20\t]+$/mg, '');
						content = content.replace(/^[\r\n]+/, '').replace(/[\r\n]*$/, '\n');
						return content;
					},
					processName: function (filePath) {
						return filePath.replace(/(.+\/)*(.*)\.hbs?/, '$2');
					}
				},
				files: {
					'./javascript/handlebar/home.js': './javascript/handlebar/home.hbs',
					'./javascript/handlebar/PageView.js': './javascript/handlebar/PageView.hbs',
					'./javascript/handlebar/header.js': './javascript/handlebar/HeaderViewTemplate.hbs',
					'./javascript/handlebar/recommendArticle.js': './javascript/handlebar/recommendArticle.hbs',
					'./javascript/handlebar/contentListItemView.js': './javascript/handlebar/contentListItemViewTemplate.hbs'
				}
			}
		},
		uglify: {
			js: {
				files: {
					'./javascript/lib/require.js': './javascript/lib/require.js',
					'./javascript/lib/backbone.js': './javascript/lib/backbone.js'/*,
					'./javascript/handlebar/templates.js': './javascript/handlebar/templates.js'*/
				}
			}
		}
    });

	grunt.loadNpmTasks('grunt-contrib-copy');
	grunt.loadNpmTasks('grunt-contrib-cssmin');
    grunt.loadNpmTasks('grunt-contrib-stylus');

	grunt.loadNpmTasks('grunt-contrib-concat');
	grunt.loadNpmTasks('grunt-contrib-uglify');

	grunt.loadNpmTasks('grunt-contrib-handlebars');

	grunt.registerTask('js', ['concat', 'copy:js', 'handlebars', 'uglify']);
    grunt.registerTask('css', ['copy:css', 'cssmin', 'stylus']);
	grunt.registerTask('default', ['js', 'css']);
};
