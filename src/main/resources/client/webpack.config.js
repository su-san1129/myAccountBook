const path = require('path')
const MiniCssExtractPlugin = require('mini-css-extract-plugin')

module.exports = {
  mode: 'development',
  devtool: 'source-map',
  entry: './src/calendar.ts',
  resolve: {
    extensions: [ '.ts', '.js' ]
  },
  module: {
    rules: [
      {
        test: /\.ts$/,
        use: 'ts-loader', // will use tsconfig.json
        exclude: /node_modules/
      },
      {
        test: /\.css$/,
        use: [
          { loader: MiniCssExtractPlugin.loader },
          { loader: 'css-loader', options: { importLoaders: 1 } }
        ]
      }
    ]
  },
  output: {
    filename: 'calendar.js',
    path: path.join(__dirname, '../static/js/calendar')
  },
  plugins: [
    new MiniCssExtractPlugin({
      filename: '../../css/calendar/calendar.css'
    })
  ]
}
